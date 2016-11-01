package com.kangyonggan.bm.service;

import com.kangyonggan.bm.model.Book;

/**
 * @author kangyonggan
 * @since 16/10/13
 */
public interface BookService {

    /**
     * 保存书籍
     *
     * @param book
     */
    void saveBook(Book book);

    /**
     * 查找书籍
     *
     * @param code
     * @return
     */
    Book findBookByCode(String code);
}
