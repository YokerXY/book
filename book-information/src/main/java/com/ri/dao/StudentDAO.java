package com.ri.dao;

import com.ri.entrty.Student;


import java.sql.SQLException;

public interface StudentDAO {
       Student getStuLoginByAccount(String account) throws SQLException;
}
