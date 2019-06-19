package com.sm.service.Impl;

import com.sm.factory.ServiceFactory;
import com.sm.service.StudentService;
import com.sm.utils.ResultEntity;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentServiceImplTest {
 private StudentService studentService = ServiceFactory.getStudentServiceInstance();
    @Test
    public void stuLogin() {
        ResultEntity resultEntity = studentService.stuLogin("1314520","520");
        System.out.println(resultEntity);
    }
}