package com.sm.service.Impl;

import com.sm.entity.Type;
import com.sm.factory.ServiceFactory;
import com.sm.service.StudentFrameService;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class StudentFrameServiceImplTest {
    private StudentFrameService studentFrameService = ServiceFactory.getStudentFrameServiceInstance();

    @Test
    public void getAll() throws SQLException {
        List<Type> typeBorrowList = studentFrameService.getAll();
        typeBorrowList.forEach(typeBorrow -> System.out.println(typeBorrow));
    }
}