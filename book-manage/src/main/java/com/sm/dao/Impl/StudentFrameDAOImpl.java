package com.sm.dao.Impl;

import com.sm.dao.StudentFrameDAO;
import com.sm.entity.StuLogin;
import com.sm.entity.Type;
import com.sm.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentFrameDAOImpl  implements StudentFrameDAO {
    @Override
    public List<Type> getAll() throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT * FROM t_type ORDER BY type_id ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Type> typeBorrowList = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return typeBorrowList;

    }

    private List<Type> convert(ResultSet rs) throws SQLException {
        List<Type> typeBorrowList = new ArrayList<>();
        while (rs.next()) {
            Type typeBorrow = new Type();
            typeBorrow.setTypeName(rs.getString("type_name"));
            typeBorrow.setId(rs.getInt("id"));
            typeBorrow.setTypeId(rs.getInt("type_id"));
            typeBorrowList.add(typeBorrow);
        }
        return typeBorrowList;
    }
}
