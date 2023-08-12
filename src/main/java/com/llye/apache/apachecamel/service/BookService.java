package com.llye.apache.apachecamel.service;

import com.llye.apache.apachecamel.mapper.BookMapper;
import com.llye.apache.apachecamel.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookMapper bookMapper;

    public BookService(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Transactional
    public void insertBook(Book book) {
        bookMapper.insertBook(book);
    }
}
