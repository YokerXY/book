package com.ri.service.Impl;

import com.ri.dao.StudentDAO;
import com.ri.entrty.Student;
import com.ri.factory.ServiceFactory;
import com.ri.service.StudentService;
import com.ri.utils.ResultEntity;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentServiceImplTest {

    private StudentService studentService = ServiceFactory.getStudentServiceInstance();
    @Test
    public void stuLogin() {
        ResultEntity resultEntity  = studentService.stuLogin("1314521","521");
        System.out.println(resultEntity);
    }
}