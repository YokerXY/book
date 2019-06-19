package com.sm.dao.impl;

import com.sm.dao.CClassDAO;
import com.sm.entity.CClass;
import com.sm.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CClassDAOImpl implements CClassDAO {
    @Override
    public List<CClass> selectByDepartmentId(int departmentId) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT * FROM t_class WHERE department_id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1,departmentId);
        ResultSet rs = pstmt.executeQuery();
        List<CClass> cClassList = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return cClassList;
    }

    @Override
    public List<CClass> selectAll() throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT * FROM t_class ORDER BY department_id ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<CClass> cClassList = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return cClassList;
    }

    /**
     * 结果集转list封装
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    private List<CClass> convert(ResultSet rs) throws SQLException {
        List<CClass> classList = new ArrayList<>();
        while (rs.next()) {
            CClass cClass = new CClass();
            cClass.setId(rs.getInt("id"));
            cClass.setDepartmentId(rs.getInt("department_id"));
            cClass.setClassName(rs.getString("class_name"));
            classList.add(cClass);
        }
        return classList;
    }
    @Override
    public int insertCClass(CClass cClass) throws SQLException {
         JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
         Connection connection = jdbcUtil.getConnection();
         String sql = "INSERT INTO t_class(department_id,class_name)VALUES(?,?)";
         PreparedStatement psmt = connection.prepareStatement(sql);
         psmt.setInt(1,cClass.getDepartmentId());
         psmt.setString(2,cClass.getClassName());
         int n = psmt.executeUpdate();
         psmt.close();
         connection.close();
        return 0;
    }

    @Override
    public int deleteById(int id) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "DELETE FROM t_class WHERE id=?";
        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setInt(1,id);
        return psmt.executeUpdate();
    }

    @Override
    public int countByDepartmentId(int departmentId) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT COUNT(*) FROM t_class WHERE department_id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1,departmentId);
        ResultSet rs = pstmt.executeQuery();
        int rowCount = 0;
        if (rs.next()) {
            rowCount = rs.getInt(1);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return rowCount;
    }
    }


