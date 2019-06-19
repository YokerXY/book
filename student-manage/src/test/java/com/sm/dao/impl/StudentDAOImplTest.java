package com.sm.dao.impl;

import com.sm.dao.StudentDAO;
import com.sm.entity.Student;
import com.sm.entity.StudentPunishments;
import com.sm.entity.StudentRewards;
import com.sm.entity.StudentVO;
import com.sm.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class StudentDAOImplTest {
    private StudentDAO studentDAO = DAOFactory.getStudentDAOInstance();

    @Test
    public void selectALL() {
        List<StudentVO> studentVOList = null;
        try {
            studentVOList = studentDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        studentVOList.forEach(studentVO -> System.out.println(studentVO));
    }

    @Test
    public void selectAll() {
        List<StudentVO> studentVOList = null;
        try {
            studentVOList = studentDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        studentVOList.forEach(cClass -> System.out.println(cClass));
    }

    @Test
    public void selectByDepartmentId() {
        List<StudentVO> studentVOList = null;
        try {
            studentVOList = studentDAO.selectByDepartmentId(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        studentVOList.forEach(cClass -> System.out.println(cClass));
    }

    @Test
    public void selectByClassId() {
        List<StudentVO> studentVOList = null;
        try {
            studentVOList = studentDAO.selectByClassId(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        studentVOList.forEach(cClass -> System.out.println(cClass));
    }

    @Test
    public void selectByKeywords() {
        List<StudentVO> studentVOList = null;
        try {
            studentVOList = studentDAO.selectByKeywords("许");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        studentVOList.forEach(cClass -> System.out.println(cClass));
    }

    @Test
    public void updateStudent() throws SQLException {
        Student student = new Student();
        student.setId("1802343301");
        student.setAddress("湖南长沙");
        student.setPhone("123456");
        int n = studentDAO.updateStudent(student);
        assertEquals(1, n);
    }

    @Test
    public void deleteById() {
        String id = "1802343301";
        try {
            studentDAO.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void insertStudent() throws SQLException {
        Student student = new Student();
        student.setId("1111121");
        student.setClassId(3);
        student.setStudentName("陈卫萍");
        student.setAvatar("1.jpg");
        student.setBirthday(new Date());
        student.setGender("女");
        student.setAddress("南京");
        student.setPhone("12345678123");
        int n = studentDAO.insertStudent(student);
        assertEquals(1, n);

    }

    @Test
    public void countByDepartment() {
        try {
            int n = studentDAO.countByDepartment(2);
            System.err.println(n);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void countByClassId() {

    }

    @Test
    public void selectAllRewards() {
        List<StudentRewards> studentVOList = null;
        try {
            studentVOList = studentDAO.selectAllRewards();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        studentVOList.forEach(StudentVO -> System.out.println(StudentVO));

    }

    @Test
    public void selectAllPunishments() {
        List<StudentPunishments> studentVOList = null;
        try {
            studentVOList = studentDAO.selectAllPunishments();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        studentVOList.forEach(StudentVO -> System.out.println(StudentVO));
    }

    @Test
    public void selectPunishmentsByPrimaryId() {
        List<StudentPunishments> studentPunishments = null;
        try {
            int primaryId = 1;
            studentPunishments = studentDAO.selectPunishmentsByPrimaryId(primaryId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        studentPunishments.forEach(studentVO -> System.out.println(studentVO));


    }

    @Test
    public void selectRewardsById() {
        List<StudentRewards> studentVOList = null;
        try {
            studentVOList = studentDAO.selectRewardsById("1802343301");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        studentVOList.forEach(studentVO -> System.out.println(studentVO));
    }

    @Test
    public void selectPunishmentsById() {
        List<StudentPunishments> studentPunishments = null;
        try {
            studentPunishments = studentDAO.selectPunishmentsById("1802343301");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        studentPunishments.forEach(studentVO -> System.out.println(studentVO));
    }

    @Test
    public void insertRewards() throws SQLException {
        StudentRewards rewards = new StudentRewards();
        rewards.setPrimaryId(6);
        rewards.setId("1802343301");
        rewards.setRewards("先进个人");
        rewards.setRewardsDate(new Date(2018-06-06));
        int n = studentDAO.insertRewards(rewards);
        assertEquals(1,n);
    }

    @Test
    public void insertPunishments()  throws  SQLException{
        StudentPunishments punishments = new StudentPunishments();
        punishments.setPrimaryId(6);
        punishments.setId("1802343302");
        punishments.setPunishments("惩罚测试");
        punishments.setPunishmentsDate(new Date(2018-06-06));
        int n = studentDAO.insertPunishments(punishments);
        assertEquals(1,n);
    }

    @Test
    public void deletePunishmentsByPrimaryId() throws  SQLException
    {
        int primaryId = 4;
        studentDAO.deletePunishmentsByPrimaryId(primaryId);
    }

    @Test
    public void countPunishments() throws SQLException {
        int n = studentDAO.countPunishments();
        System.out.println(n);
    }

    @Test
    public void countRewards() throws SQLException {
        int n = studentDAO.countRewards();
        System.out.println(n);
    }
}