package com.ri.dao.Impl;

import com.ri.dao.StudentDAO;
import com.ri.entrty.Student;
import com.ri.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public Student getStuLoginByAccount(String account) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT * FROM t_stulogin WHERE account = ? ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, account);
        ResultSet rs = pstmt.executeQuery();
        Student stuLogin = null;
        while (rs.next()) {
            int id = rs.getInt("reader_id");
            String adminAccount = rs.getString("account");
            String password = rs.getString("password");
            String adminName = rs.getString("stu_name");
            stuLogin = new Student();
            stuLogin.setLoginId(id);
            stuLogin.setAccount(adminAccount);
            stuLogin.setPassword(password);
            stuLogin.setStudentName(adminName);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return stuLogin;
    }
}
