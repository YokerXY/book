package com.sm.service.Impl;

import com.sm.dao.BookDAO;
import com.sm.dao.ReaderDAO;
import com.sm.dao.TypeDAO;
import com.sm.entity.Book;
import com.sm.factory.DAOFactory;
import com.sm.service.BookService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookServiceImpl implements BookService {
    private BookDAO bookDAO = DAOFactory.getBookDAOInstance();
    private TypeDAO typeDAO = DAOFactory.getTypeDAOInstance();
    private ReaderDAO readerDAO = DAOFactory.getReaderDAOInstance();

    @Override
    public List<Book> selectAll() {
        List<Book> bookList = null;
        try {
            bookList = bookDAO.getAll();
        } catch (SQLException e) {
            System.err.print("查询图书信息出现异常");
        }
        return bookList;
    }

    @Override
    public void deleteBook(int id) {
        try {
            bookDAO.deleteBooks(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int addBook(Book book) {
        int n = 0;
        try {
            n = bookDAO.insertBook(book);
        } catch (SQLException e) {
            System.err.print("新增图书出现异常");
        }
        return n;
    }

    @Override
    public List<Map> selectBookInfo() {
        List<Book> bookList = null;
        try {
            bookList = bookDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Map> mapList = new ArrayList<>();
        for (Book book : bookList) {
            Map<String, Object> map = new HashMap();
            map.put("book", book);
            try {
                map.put("typeCount", typeDAO.countBookByTypeId(book.getId()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                map.put("readerCount", readerDAO.countByTypeId(book.getId()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            mapList.add(map);
        }
        return mapList;
    }
}
