package com.sm.dao.Impl;

import com.sm.dao.AdminDAO;
import com.sm.entity.Admin;
import com.sm.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAOImpl  implements AdminDAO {
    @Override
    public Admin getAdminByAccount(String account) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT * FROM t_admin WHERE account = ? ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, account);
        ResultSet rs = pstmt.executeQuery();
        Admin admin = null;
        while (rs.next()) {
            int id = rs.getInt("admin_id");
            String adminName = rs.getString("admin_name");
            String adminAccount = rs.getString("account");
            String password = rs.getString("password");
            admin = new Admin();
            admin.setAdminName(adminName);
            admin.setAccount(adminAccount);
            admin.setPassword(password);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return admin;
    }

    @Override
    public int insertGlyLogin(Admin admin) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "INSERT INTO t_admin(account,admin_name,password) VALUES (?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,admin.getAccount());
        pstmt.setString(2,admin.getAdminName());
        pstmt.setString(3,admin.getPassword());
        int n = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }
}
