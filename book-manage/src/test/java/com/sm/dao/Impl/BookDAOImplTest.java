package com.sm.dao.Impl;

import com.sm.dao.BookDAO;
import com.sm.entity.Book;
import com.sm.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class BookDAOImplTest {
    private BookDAO bookDAO = DAOFactory.getBookDAOInstance();
    @Test
    public void getAll() {
        List<Book> bookList = null;
        try {
            bookList = bookDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        bookList.forEach(book -> System.out.println(book));

    }

    @Test
    public void deleteBooks() throws SQLException {
        System.out.println(bookDAO.deleteBooks(5));


    }

    @Test
    public void insertBook() {
        Book book = new Book();
        book.setBookName("鬼吹灯");
        book.setAuthor("秋水");
        book.setPrice((double) 40);
        book.setCover("https://img1.doubanio.com/view/subject/m/public/s29888408.jpg");
        try {
            int n = bookDAO.insertBook(book);
            assertEquals(1, n);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}