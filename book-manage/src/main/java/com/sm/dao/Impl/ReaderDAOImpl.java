package com.sm.dao.Impl;

import com.sm.dao.ReaderDAO;
import com.sm.entity.Reader;
import com.sm.entity.ReaderVO;
import com.sm.utils.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderDAOImpl implements ReaderDAO {

    @Override
    public List<ReaderVO> selectAll() throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.*,t2.type_name,t3.book_name\n" +
                "FROM t_reader t1\n" +
                "LEFT JOIN t_type t2\n" +
                "ON t1.class_id=t2.id\n" +
                "LEFT JOIN t_book t3\n" +
                "ON t2.type_id=t3.id";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<ReaderVO> readerList = new ArrayList<>();
        while (rs.next()) {
            ReaderVO reader = new ReaderVO();
            reader.setId(rs.getString("id"));
            reader.setBookName(rs.getString("book_name"));
            reader.setRole(rs.getString("role"));
            reader.setName(rs.getString("name"));
            reader.setJoin_date(rs.getDate("join_date"));
            reader.setEmail(rs.getString("email"));
            reader.setMobile(rs.getString("mobile"));
            reader.setTypeName(rs.getString("type_name"));
            readerList.add(reader);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return readerList;
    }

    @Override
    public List<ReaderVO> selectByTypeId(int typeId) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.*,t2.type_name,t3.book_name\n" +
                "FROM t_reader t1\n" +
                "LEFT JOIN t_type t2\n" +
                "ON t1.class_id=t2.id\n" +
                "LEFT JOIN t_book t3\n" +
                "ON t2.type_id=t3.id\n" +
                "WHERE t3.id=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, typeId);
        ResultSet rs = pstmt.executeQuery();
        List<ReaderVO> readers = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return readers;
    }

    @Override
    public List<ReaderVO> selectByClassId(int classId) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.*,t2.type_name,t3.book_name\n" +
                "FROM t_reader t1\n" +
                "LEFT JOIN t_type t2\n" +
                "ON t1.class_id=t2.id\n" +
                "LEFT JOIN t_book t3\n" +
                "ON t2.type_id=t3.id\n" +
                "WHERE t2.id=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, classId);
        ResultSet rs = pstmt.executeQuery();
        List<ReaderVO> readers = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return readers;
    }

    @Override
    public List<ReaderVO> selectByKeywords(String keywords) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.*,t2.type_name,t3.book_name\n" +
                "FROM t_reader t1\n" +
                "LEFT JOIN t_type t2\n" +
                "ON t1.class_id=t2.id\n" +
                "LEFT JOIN t_book t3\n" +
                "ON t2.type_id=t3.id\n" +
                "WHERE t1.name LIKE ? OR t1.role LIKE ?\n";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, "%" + keywords + "%");
        pstmt.setString(2, "%" + keywords + "%");
        ResultSet rs = pstmt.executeQuery();
        List<ReaderVO> readers = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return readers;
    }

    @Override
    public int updateReader(Reader reader) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "UPDATE t_reader SET email = ?,mobile = ? WHERE id =?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, reader.getEmail());
        pstmt.setString(2, reader.getMobile());
        pstmt.setInt(3, reader.getId());
        int n = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }



    @Override
    public int deleteById(String id) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "DELETE FROM t_reader WHERE id = ?";
        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setString(1, id);
        int n = psmt.executeUpdate();
        connection.close();
        return n;
    }

    @Override
    public int insertReader(com.sm.entity.Reader reader) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "INSERT INTO t_reader  VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, reader.getId());
        pstmt.setInt(2, reader.getClass_id());
        pstmt.setString(3, reader.getAvatar());
        pstmt.setString(4, reader.getName());
        pstmt.setString(5, reader.getRole());
        pstmt.setDate(6, new Date(reader.getJoin_date().getTime()));
        pstmt.setString(7, reader.getEmail());
        pstmt.setString(8, reader.getMobile());
        int n = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }

    @Override
    public int countByTypeId(int typeId) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT COUNT(*) FROM t_reader t1" +
                " LEFT JOIN t_type t2 " +
                "ON t1.`class_id` =t2.`id`\n" +
                "LEFT JOIN t_book t3 " +
                "ON t2.`type_id` = t3.`id`\n" +
                "WHERE t3.`id`=?";
        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setInt(1, typeId);
        ResultSet rs = psmt.executeQuery();
        int rowCount = 0;
        if (rs.next()) {
            rowCount = rs.getInt(1);
        }
        rs.close();
        psmt.close();
        jdbcUtil.closeConnection();
        return rowCount;
    }
    private List<ReaderVO> convert(ResultSet rs) throws SQLException {
        List<ReaderVO> readers = new ArrayList<>();
        while (rs.next()) {
            ReaderVO readerVO = new ReaderVO();
            readerVO.setId(rs.getString("id"));
            readerVO.setBookName(rs.getString("book_name"));
            readerVO.setRole(rs.getString("role"));
            readerVO.setName(rs.getString("name"));
            readerVO.setJoin_date(rs.getDate("join_date"));
            readerVO.setEmail(rs.getString("email"));
            readerVO.setMobile(rs.getString("mobile"));
            readerVO.setTypeName(rs.getString("type_name"));
            readers.add(readerVO);
        }
        return readers;
    }
}
