package com.sm.service.Impl;

import com.sm.entity.Student;
import com.sm.entity.StudentVO;
import com.sm.factory.ServiceFactory;
import com.sm.service.StudentService;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class StudentServiceImplTest {
    StudentService studentService = ServiceFactory.getStudentServiceInstance();

    @Test
    public void selectAll() {
        List<StudentVO> studentVOList = studentService.selectAll();
        studentVOList.forEach(studentVO -> System.out.println(studentVO));
    }

    @Test
    public void selectByDepartmentId() {
        List<StudentVO> studentVOList = studentService.selectByDepartmentId(1);
        studentVOList.forEach(studentVO -> System.out.println(studentVO));
    }

    @Test
    public void selectByClassId() {
        List<StudentVO> studentVOList = studentService.selectByClassId(2);
        studentVOList.forEach(studentVO -> System.out.println(studentVO));
    }

    @Test
    public void selectByKeywords() {
        List<StudentVO> studentVOList = studentService.selectByKeywords("许");
        studentVOList.forEach(studentVO -> System.out.println(studentVO));
    }


    @Test
    public void updateStudent() {
        Student student = new Student();
        student.setId("1802343303");
        student.setPhone("123456789");
        student.setAddress("江苏徐州");
        studentService.updateStudent(student);
    }

    @Test
    public void insertStudent() {
        Student student = new Student();
        student.setId("111111");
        student.setClassId(3);
        student.setStudentName("副萍");
        student.setAvatar("1.jpg");
        student.setBirthday(new Date());
        student.setGender("女");
        student.setAddress("南京");
        student.setPhone("12343");
        int n = studentService.insertStudent(student);
        System.out.println(n);
    }

    @Test
    public void countPunishments() {
        int n = studentService.countPunishments();
        System.out.println(n);
    }

    @Test
    public void countRewards() {
        int n = studentService.countRewards();
        System.out.println(n);
    }

    @Test
    public void deletePunishmentsByPrimaryId() {
        int primaryId = 4;
        studentService.deletePunishmentsByPrimaryId(primaryId);
    }
}

