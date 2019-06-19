package com.sm.service.Impl;

import com.sm.dao.StudentFrameDAO;
import com.sm.entity.Type;
import com.sm.factory.DAOFactory;
import com.sm.service.StudentFrameService;
import com.sm.service.StudentService;
import com.sm.utils.ResultEntity;

import java.sql.SQLException;
import java.util.List;

public class StudentFrameServiceImpl implements StudentFrameService {
    private StudentFrameDAO studentFrameDAO = DAOFactory.getStudentInstance();

    @Override
    public List<Type> getAll() throws SQLException {
        List<Type> typeBorrowList = null;
        try {
            typeBorrowList = studentFrameDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeBorrowList;
    }

}
