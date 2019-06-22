package com.ri.dao.Impl;

import com.ri.dao.ReaderInformationDAO;
import com.ri.entrty.ReaderInformation;
import com.ri.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReaderInformationDAOImpl implements ReaderInformationDAO {
    @Override
    public List<ReaderInformation> selectAllIn(String id) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.*,t3.`book_name`,t3.`cover` FROM t_reader t1 \n" +
                "LEFT JOIN borrow_back t2 ON t2.`reader_id` = t1.`id`\n" +
                "LEFT JOIN t_book t3 ON t2.`book_id`=t3.`id`\n" +
                "WHERE t1.`id` LIKE ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();
        List<ReaderInformation> bookList = new ArrayList<>();
        while (rs.next()){
            ReaderInformation book = new ReaderInformation();
            book.setId(rs.getString("id"));
            book.setReaderName(rs.getString("name"));
            book.setAvatar(rs.getString("avatar"));
            book.setRole(rs.getString("role"));
            book.setJoinDate(rs.getDate("join_date"));
            book.seteMail(rs.getString("email"));
            book.setMobile(rs.getString("mobile"));
            book.setBookName(rs.getString("book_name"));
            book.setBookAvatar(rs.getString("cover"));
            bookList.add(book);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return bookList;
    }
}
