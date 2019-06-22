package com.ri.dao;

import com.ri.entrty.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDAO {

    List<Book> selectAllBook() throws SQLException;
    int selectBook(int id) throws SQLException;
}
