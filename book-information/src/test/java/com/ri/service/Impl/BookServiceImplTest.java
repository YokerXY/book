package com.ri.service.Impl;

import com.ri.entrty.Book;
import com.ri.factory.ServiceFactory;
import com.ri.service.BookService;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceImplTest {

    private BookService bookService = ServiceFactory.getBookServiceInstance();
    @Test
    public void selectAllBook() {

        List<Book> bookList =bookService.selectAllBook();
        bookList.forEach(book -> System.out.println(book));
    }
}