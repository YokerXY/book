package com.sm.dao.Impl;

import com.sm.dao.TypeDAO;
import com.sm.entity.Book;
import com.sm.entity.Type;
import com.sm.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeDAOImpl implements TypeDAO {

    @Override
    public List<Type> selectAll() throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT * FROM t_type ORDER BY type_id ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Type> typeList = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return typeList;
    }

    @Override
    public List<Type> selectByTypeId(int typeId) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT * FROM t_type WHERE type_id = ? ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, typeId);
        ResultSet rs = pstmt.executeQuery();
        List<Type> typeList = new ArrayList<>();
        while (rs.next()) {
            Type type = new Type();
            type.setId(rs.getInt("id"));
            type.setId(rs.getInt("type_id"));
            type.setTypeName(rs.getString("type_name"));
            typeList.add(type);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return typeList;
    }

    @Override
    public int insertType(Type type) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "INSERT INTO t_type (id,type_id,type_name) VALUES (?,?,?) ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, type.getId());
        pstmt.setInt(2, type.getTypeId());
        pstmt.setString(3, type.getTypeName());
        int n = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }

    @Override
    public int deleteTypes(Integer id) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "DELETE FROM t_type WHERE id =?";
        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setInt(1, id);
        return psmt.executeUpdate();
    }

    @Override
    public List<Book> selectByBookId(int typeId) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT * FROM t_book WHERE type_id = ? ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, typeId);
        ResultSet rs = pstmt.executeQuery();
        List<Book> typeList = new ArrayList<>();
        while (rs.next()) {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setBookName(rs.getString("book_name"));
            typeList.add(book);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return typeList;

    }

    @Override
    public int countBookByTypeId(int typeId) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT COUNT(t1.`id`) \n" +
                "FROM t_book t1\n" +
                "LEFT JOIN t_type t2\n" +
                "ON t1.`type_id` = t2.`type_id`\n" +
                "WHERE t2.`type_id` = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, typeId);
        ResultSet rs = pstmt.executeQuery();
        int countBookByTypeId = 0;
        if (rs.next()) {
            countBookByTypeId = rs.getInt(1);
        }
        return countBookByTypeId;
    }

    private List<Type> convert(ResultSet rs) throws SQLException{
        List<Type> typeList = new ArrayList<>();
        while (rs.next()){
            Type type = new Type();
            type.setId(rs.getInt("id"));
            type.setTypeId(rs.getInt("type_id"));
            type.setTypeName(rs.getString("type_name"));
            typeList.add(type);
        }
        return typeList;
    }
}
