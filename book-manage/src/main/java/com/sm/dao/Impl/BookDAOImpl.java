package com.sm.dao.Impl;

import com.sm.dao.BookDAO;
import com.sm.entity.Book;
import com.sm.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    @Override
    public List<Book> getAll() throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT * FROM t_book ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Book> bookList = new ArrayList<>();
        while (rs.next()){
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setBookName(rs.getString("book_name"));
            book.setAuthor(rs.getString("author"));
            book.setPrice(rs.getDouble("price"));
            book.setCover(rs.getString("cover"));
            bookList.add(book);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return bookList;
    }


    @Override
    public int deleteBooks(Integer id) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "DELETE FROM t_book WHERE id =?";
        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setInt(1,id);
        return psmt.executeUpdate();
    }

    @Override
    public int insertBook(Book book) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "INSERT INTO t_book (book_name,author,price,cover) VALUES (?,?,?,?) ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,book.getBookName());
        pstmt.setString(2,book.getAuthor());
        pstmt.setString(3, String.valueOf(book.getPrice()));
        pstmt.setString(4,book.getCover());
        int n = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }
}
