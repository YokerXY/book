package com.ri.dao.Impl;

import com.ri.dao.StudentFrameDAO;
import com.ri.entrty.BorrowVO;
import com.ri.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class StudentFrameDAOImplTest {
    private StudentFrameDAO studentFrameDAO = DAOFactory.getStudentFrameDAOInstance();
    @Test
    public void getBorrowByStudentAccount() {
        List<BorrowVO> borrowVOList = null;
        try {
            borrowVOList = studentFrameDAO.getBorrowByStudentAccount("1314521");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        borrowVOList.forEach(borrowVO -> System.out.println(borrowVO));
    }
}