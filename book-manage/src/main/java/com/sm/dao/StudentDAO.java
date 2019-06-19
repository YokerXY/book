package com.sm.dao;

import com.sm.entity.StuLogin;

import java.sql.SQLException;

public interface StudentDAO {
       StuLogin getStuLoginByAccount(String account) throws SQLException;
}
