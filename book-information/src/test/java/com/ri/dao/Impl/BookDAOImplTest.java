package com.ri.dao.Impl;

import com.ri.dao.BookDAO;
import com.ri.entrty.Book;
import com.ri.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class BookDAOImplTest {

    private BookDAO bookDAO = DAOFactory.getBookDAOInstance();
    @Test
    public void selectAllBook() {
        List<Book> bookList = null;
        try {
            bookList = bookDAO.selectAllBook();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        bookList.forEach(book -> System.out.println(book));

    }
}