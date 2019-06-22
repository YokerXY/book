package com.ri.service.Impl;

import com.ri.dao.BookDAO;
import com.ri.entrty.Book;
import com.ri.factory.DAOFactory;
import com.ri.service.BookService;

import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDAO bookDAO= DAOFactory.getBookDAOInstance();
    @Override
    public List<Book> selectAllBook() {
        List<Book> bookList = null;
        try {
            bookList = bookDAO.selectAllBook();
        } catch (SQLException e) {
            System.err.print("查询图书信息出现异常");
        }
        return bookList;
    }

    @Override
    public int selectBook(int id) {
        int n = 0;
        try {
            n= bookDAO.selectBook(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }
}
