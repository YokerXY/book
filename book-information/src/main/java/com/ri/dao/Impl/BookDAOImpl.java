package com.ri.dao.Impl;

import com.ri.dao.BookDAO;
import com.ri.entrty.Book;
import com.ri.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    @Override
    public List<Book> selectAllBook() throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.`id`,t2.`type_name`,t1.`book_name`," +
                "t1.`author`,t1.`price`,t1.`cover`,t1.`summary`,t1.`stock` FROM t_book t1\n" +
                "LEFT JOIN t_type t2 ON t1.`type_id`=t2.`id` ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Book> bookList = new ArrayList<>();
        while (rs.next()){
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setTypeName(rs.getString("type_name"));
            book.setBookName(rs.getString("book_name"));
            book.setAuthor(rs.getString("author"));
            book.setPrice(rs.getString("price"));
            book.setCover(rs.getString("cover"));
            book.setSummary(rs.getString("summary"));
            book.setStock(rs.getInt("stock"));
            bookList.add(book);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return bookList;
    }

    @Override
    public int selectBook(int id) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "DELETE FROM t_book where id =?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, id);
        int n = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }
}
