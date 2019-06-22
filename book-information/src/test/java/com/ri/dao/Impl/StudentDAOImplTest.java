package com.ri.dao.Impl;

import com.ri.dao.StudentDAO;
import com.ri.entrty.Student;
import com.ri.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class StudentDAOImplTest {

    private StudentDAO studentDAO = DAOFactory.getStudentDAOInstance();
    @Test
    public void getStuLoginByAccount() {
        try {
            studentDAO.getStuLoginByAccount("1314521");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("账号存在");
    }
}