package com.kangyonggan.bm.util;

import com.kangyonggan.bm.exception.ConfigException;
import com.kangyonggan.bm.exception.ConnectException;
import com.kangyonggan.bm.exception.ParseException;
import com.kangyonggan.bm.model.Book;
import com.kangyonggan.bm.model.Chapter;
import com.kangyonggan.bm.service.BookService;
import com.kangyonggan.bm.service.ChapterService;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @author kangyonggan
 * @since 2016/11/2
 */
@Log4j2
public class BookHelper {

    private static ChapterService chapterService;
    private static BookService bookService;

    static {
        chapterService = SpringUtils.getBean(ChapterService.class);
        bookService = SpringUtils.getBean(BookService.class);
    }

    /**
     * 新增/更新书籍
     *
     * @param code
     * @return
     */
    public static boolean parse(String code) {
        Config config;
        try {
            config = ConfigFactory.getConfig(code);
        } catch (ConfigException e) {
            log.error("读取配置文件异常", e);
            return false;
        }
        log.info("配置文件：{}", config);

        Document doc;
        Book book = bookService.findBookByCode(code);
        Chapter lastChapter = chapterService.findLastChapter(code);
        try {
            doc = BookHelper.parseHtml(config.getValue("baseUrl"));
            if (book == null) {
                book = BookHelper.parseBook(doc, code);
                bookService.saveBook(book);
            }

            BookHelper.parseChapterList(doc, book, lastChapter);
        } catch (Exception e) {
            log.error("新增/更新书籍异常", e);
            return false;
        }

        log.info("新增/更新书籍成功");
        return true;
    }

    private static void parseChapterList(Document doc, Book book, Chapter lastChapter) throws ConfigException, ParseException, ConnectException {
        Config config = ConfigFactory.getConfig(book.getCode());

        try {
            Elements elements = doc.select(config.getValue("chapterListSelect"));
            int startLine = Integer.parseInt(config.getValue("startLine"));

            int start = startLine;
            if (lastChapter != null) {
                start += lastChapter.getChapterNo();
            }

            for (int i = start; i < elements.size(); i++) {
                Element element = elements.get(i);
                String title = element.select("a").text();
                title = title.substring(title.indexOf(" ") + 1);
                String url = element.select("a").attr("href");

                Chapter chapter = new Chapter();
                chapter.setBookCode(book.getCode());
                chapter.setBookName(book.getName());
                chapter.setTitle(title);
                chapter.setChapterNo(i + 1 - startLine);

                Document d = parseHtml(config.getValue("chapterUrl") + url);
                chapter.setBody(d.select(config.getValue("chapterBodySelect")).html());

                chapterService.saveChapter(chapter);
                log.debug("新增章节成功：{}" + chapter);
            }
            log.info("一共新增{}个章节", elements.size() - start);
        } catch (Exception e) {
            throw e;
        }

    }

    private static Document parseHtml(String url) throws ConfigException, ConnectException {
        Document doc = null;

        int retryCount = 0;
        while (retryCount < 5) {
            try {
                doc = Jsoup.connect(url).header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:33.0) Gecko/20100101 Firefox/33.0").timeout(10000).get();
                log.info("网页读取成功");
                break;
            } catch (IOException e) {
                log.error("读取网页{}失败, 将重试5次, 现在是第{}次重试", url, ++retryCount);
            }
        }

        if (retryCount >= 5) {
            log.error("重试5此后， 网页仍然读取失败");
            throw new ConnectException();
        }

        return doc;
    }

    private static Book parseBook(Document doc, String code) throws ConfigException, ParseException {
        Config config = ConfigFactory.getConfig(code);

        try {
            String name = doc.select(config.getValue("bookNameSelect")).get(0).text();
            String author = doc.select(config.getValue("bookAuthorSelect")).get(0).text();
            author = author.substring(author.indexOf("：") + 1);
            String summary = doc.select(config.getValue("bookSummarySelect")).get(0).text();

            Book book = new Book();
            book.setCode(code);
            book.setName(name);
            book.setAuthor(author);
            book.setSummary(summary);

            log.info("书籍解析成功：{}", book);
            return book;
        } catch (Exception e) {
            throw new ParseException(e);
        }
    }

}
