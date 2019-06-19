package com.sm.dao;

import com.sm.entity.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDAO {
    /**
     * 查询所有书名
     * @return List<Book>
     * @throws SQLException
     */
    List<Book> getAll() throws SQLException;
    int deleteBooks(Integer id) throws SQLException;
    int insertBook(Book book) throws SQLException;
}
