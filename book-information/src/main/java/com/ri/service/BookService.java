package com.ri.service;

import com.ri.entrty.Book;

import java.util.List;

public interface BookService {
    List<Book> selectAllBook();

    int selectBook(int id);
}
