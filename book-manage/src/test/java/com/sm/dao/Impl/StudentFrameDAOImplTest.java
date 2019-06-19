package com.sm.dao.Impl;

import com.sm.dao.StudentFrameDAO;
import com.sm.entity.StuLogin;
import com.sm.entity.Type;
import com.sm.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class StudentFrameDAOImplTest {
    private StudentFrameDAO studentFrameDAO = DAOFactory.getStudentInstance();
    @Test
    public void getAll() {
        List<Type> studentFrameList = null;
        try {
            studentFrameList = studentFrameDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        studentFrameList.forEach(typeBorrow -> System.out.println(typeBorrow));
    }
}