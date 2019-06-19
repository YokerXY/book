package com.sm.dao;

import com.sm.entity.Student;
import com.sm.entity.StudentPunishments;
import com.sm.entity.StudentRewards;
import com.sm.entity.StudentVO;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {
    /**
     * 查询所有学生（视图对象
     * @return   List<StudentVO>
     * @throws SQLException
     */

    List<StudentVO> selectAll() throws SQLException;


    /**
     * 根据院系查询学生
     * @param departmentId
     * @return departmentId
     * @throws SQLException
     */
    List<StudentVO> selectByDepartmentId(int departmentId) throws SQLException;

    /**
     * 根据班级查询学生
     * @param classId
     * @return classId
     * @throws SQLException
     */
    List<StudentVO> selectByClassId(int classId) throws SQLException;


    /**
     * 根据关键字查询学生
     * @param keywords
     * @return keywords
     * @throws SQLException
     */
    List<StudentVO> selectByKeywords(String keywords) throws SQLException;

    /**
     * 跟新学生信息
     * @param student
     * @return
     * @throws SQLException
     */


    int  updateStudent(Student student) throws  SQLException;

    /**
     * 根据id删除学生
     * @param id
     * @return
     * @throws SQLException
     */
    int deleteById(String id) throws  SQLException;


    /**
     * 新增学生
     */
    int insertStudent(Student student)throws SQLException;
    int countByDepartment(int departmentId) throws SQLException;
    /**
     * 根据班级Id统计学生人数
     *
     * @param classId
     * @return int
     * @throws SQLException
     */
    int countByClassId(int classId) throws SQLException;
    /**
     * 根据学生id查询学生
     * @param
     * @return
     * @throws SQLException
     */
    List<StudentRewards> selectAllRewards() throws SQLException;

    List<StudentPunishments> selectAllPunishments() throws SQLException;

    List<StudentPunishments> selectPunishmentsByPrimaryId(int primaryId) throws SQLException;



    /**
     * 根据学生学号查询学生得奖情况
     * @param id
     * @return
     * @throws SQLException
     */
    List<StudentRewards> selectRewardsById(String id) throws  SQLException;

    /**
     * 根据学生学号查询学生违纪情况
     * @param id
     * @return
     * @throws SQLException
     */
    List<StudentPunishments> selectPunishmentsById(String id) throws  SQLException;

    int insertRewards(StudentRewards rewards)throws SQLException;

    int insertPunishments(StudentPunishments punishments) throws SQLException;

    int deletePunishmentsByPrimaryId(int primaryId) throws SQLException;

    int countPunishments() throws SQLException;
    int countRewards() throws SQLException;
}
