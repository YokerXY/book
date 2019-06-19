package com.sm.service;

import com.sm.entity.Book;

import java.util.List;
import java.util.Map;

public interface BookService {
    List<Book> selectAll();

    /**
     * 删除图书
     * @param id
     */
    void deleteBook(int id);

    /**
     * 新增图书
     * @param book
     * @return
     */
    int addBook(Book book);
    List<Map> selectBookInfo();
}
