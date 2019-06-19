package com.sm.service.Impl;

import com.sm.dao.StudentDAO;
import com.sm.entity.Student;
import com.sm.entity.StudentPunishments;
import com.sm.entity.StudentRewards;
import com.sm.entity.StudentVO;
import com.sm.factory.DAOFactory;
import com.sm.service.StudentService;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO = DAOFactory.getStudentDAOInstance();

    @Override
    public List<StudentVO> selectAll() {
        List<StudentVO> students = null;
        try {
            students = studentDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<StudentVO> selectByDepartmentId(int departmentId) {
        List<StudentVO> studentVOList = null;
        try {
            studentVOList = studentDAO.selectByDepartmentId(departmentId);
        } catch (SQLException e) {
            System.err.println("根据院系查询学生信息出现异常");
        }
        return studentVOList;
    }

    @Override
    public List<StudentVO> selectByClassId(int classId) {
        List<StudentVO> studentVOList = null;
        try {
            studentVOList = studentDAO.selectByClassId(classId);
        } catch (SQLException e) {
            System.err.println("根据院系查询学生信息出现异常");
        }
        return studentVOList;
    }

    @Override
    public List<StudentVO> selectByKeywords(String keywords) {
        List<StudentVO> studentVOList = null;
        try {
            studentVOList = studentDAO.selectByKeywords(keywords);
        } catch (SQLException e) {
            System.err.println("根据院系查询学生信息出现异常");
        }
        return studentVOList;
    }

    @Override
    public void deleteStudent(String id) {
        try {
            studentDAO.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public int updateStudent(Student student) {
        try {
            studentDAO.updateStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insertStudent(Student student) {
        try {
            studentDAO.insertStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int countStudentByClassId(int classId) {
        int n = 0;
        try {
            n = studentDAO.countByClassId(classId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public List<StudentRewards> selectRewardsById(String id) {
        List<StudentRewards> rewards = null;
        try {
            rewards= studentDAO.selectRewardsById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rewards;
    }

    @Override
    public List<StudentPunishments> selectPunishmentsById(String id) {
        List<StudentPunishments> studentPunishments = null;
        try {
            studentPunishments= studentDAO.selectPunishmentsById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentPunishments;
    }

    @Override
    public List<StudentPunishments> selectPunishmentsByPrimaryId(int primaryId) {
        List<StudentPunishments> studentPunishments = null;
        try {
            studentPunishments= studentDAO.selectPunishmentsByPrimaryId(primaryId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentPunishments;
    }

    @Override
    public List<StudentRewards> selectAllRewards() {
        List<StudentRewards> studentList = null;
        try {
            studentList = studentDAO.selectAllRewards();
        } catch (SQLException e) {
            System.err.print("查询学生得奖信息出现异常");
        }
        return studentList;
    }

    @Override
    public List<StudentPunishments> selectAllPunishments() {
        List<StudentPunishments> studentList = null;
        try {
            studentList = studentDAO.selectAllPunishments();
        } catch (SQLException e) {
            System.err.print("查询学生得奖信息出现异常");
        }
        return studentList;
    }

    @Override
    public int countPunishments() {
        int n = 0;
        try {
            n=studentDAO.countPunishments();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int countRewards() {
        int n = 0;
        try {
            n=studentDAO.countRewards();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int insertRewards(StudentRewards rewards) throws SQLException {
        int n = 0;
        try {
            n=studentDAO.insertRewards(rewards);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int insertPunishments(StudentPunishments punishments) throws SQLException {
        int n = 0;
        try {
            n=studentDAO.insertPunishments(punishments);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public void deletePunishmentsByPrimaryId(int primaryId) {
        try {
            studentDAO.deletePunishmentsByPrimaryId(primaryId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}









