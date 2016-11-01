package com.kangyonggan.bm.service.impl;

import com.kangyonggan.bm.constants.AppConstants;
import com.kangyonggan.bm.model.Book;
import com.kangyonggan.bm.service.BookService;
import org.springframework.stereotype.Service;

/**
 * @author kangyonggan
 * @since 2016/11/1
 */
@Service
public class BookServiceImpl extends BaseService<Book> implements BookService {

    @Override
    public void saveBook(Book book) {
        super.insertSelective(book);
    }

    @Override
    public Book findBookByCode(String code) {
        Book book = new Book();
        book.setCode(code);
        book.setIsDeleted(AppConstants.IS_DELETED_NO);

        return super.selectOne(book);
    }
}
