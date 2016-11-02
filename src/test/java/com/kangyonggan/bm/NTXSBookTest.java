package com.kangyonggan.bm;

import com.kangyonggan.bm.model.Book;
import com.kangyonggan.bm.model.Chapter;
import com.kangyonggan.bm.service.BookService;
import com.kangyonggan.bm.service.ChapterService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;

/**
 * 逆天邪神
 *
 * @author kangyonggan
 * @since 2016/11/1
 */
public class NTXSBookTest extends BaseTestCase {

    private static final String BASE_URL = "http://www.37zw.com/3/3531/";

    @Autowired
    private BookService bookService;

    @Autowired
    private ChapterService chapterService;

    @Test
    public void testSaveBook() throws Exception {
        Book book = new Book();
        Document doc = Jsoup.parse(new URL(BASE_URL), 100000);

        String name = doc.select("#maininfo #info h1").text();

        String author = doc.select("#maininfo #info p").get(0).text();
        author = author.substring(author.indexOf("：") + 1);

        String summary = doc.select("#maininfo #intro p").get(0).text();

        book.setName(name);
        book.setAuthor(author);
        book.setCode("ntxs");
        book.setSummary(summary);

        log.debug(book);
        bookService.saveBook(book);
    }

    @Test
    public void testSaveChapter() throws Exception {
        Book book = bookService.findBookByCode("ntxs");
        log.debug(book);

        Document doc = Jsoup.parse(new URL(BASE_URL), 100000);
        Elements elements = doc.select("#list dl dd");

        for (int i = 22; i < elements.size(); i++) {
            Element element = elements.get(i);
            String title = element.select("a").text();
            title = title.substring(title.indexOf(" ") + 1);
            String url = element.select("a").attr("href");

            Chapter chapter = new Chapter();
            chapter.setBookCode(book.getCode());
            chapter.setBookName(book.getName());
            chapter.setTitle(title);
            chapter.setChapterNo(i);

            chapter.setBody(getBody(url));

            log.debug(chapter);
            chapterService.saveChapter(chapter);
        }

    }

    @Test
    public void testUpdateChapter() throws Exception {
        Book book = bookService.findBookByCode("ntxs");
        log.debug(book);

        Document doc = Jsoup.parse(new URL(BASE_URL), 100000);
        Elements elements = doc.select("#list dl dd");

        Chapter lastChapter = chapterService.findLastChapter("ntxs");

        if (lastChapter != null) {
            for (int i = lastChapter.getChapterNo() + 1; i < elements.size(); i++) {
                Element element = elements.get(i);
                String title = element.select("a").text();
                title = title.substring(title.indexOf(" ") + 1);
                String url = element.select("a").attr("href");

                Chapter chapter = new Chapter();
                chapter.setBookCode(book.getCode());
                chapter.setBookName(book.getName());
                chapter.setTitle(title);
                chapter.setChapterNo(i);

                chapter.setBody(getBody(url));

                log.debug(chapter);
                chapterService.saveChapter(chapter);
            }
        }
    }

    private String getBody(String url) throws Exception {
        Document doc = Jsoup.parse(new URL(BASE_URL + url), 100000);
        return doc.select("#content").html();
    }

}