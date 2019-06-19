package com.sm.service;

import com.sm.entity.Student;
import com.sm.entity.StudentPunishments;
import com.sm.entity.StudentRewards;
import com.sm.entity.StudentVO;
import java.sql.SQLException;
import java.util.List;
public interface StudentService {
    List<StudentVO> selectAll();
    List<StudentVO> selectByDepartmentId(int departmentId);
    List<StudentVO> selectByClassId(int classId);
    List<StudentVO> selectByKeywords(String keywords);
    /**
     *
     * @param id
     */
    void deleteStudent(String  id);

    int updateStudent(Student student);

    /**
     *
     * @param student
     * @return
     */
    int insertStudent(Student student);
    /**
     * @param classId
     * @return
     */
    int countStudentByClassId(int classId);
    List<StudentRewards> selectRewardsById(String  id);
    List<StudentPunishments> selectPunishmentsById(String  id);
    List<StudentPunishments> selectPunishmentsByPrimaryId(int primaryId);
    List<StudentRewards> selectAllRewards();
    List<StudentPunishments> selectAllPunishments();
    int countPunishments();
    int countRewards();
    int insertRewards(StudentRewards rewards)throws SQLException;
    int insertPunishments(StudentPunishments punishments) throws SQLException;
    void deletePunishmentsByPrimaryId(int primaryId);

}
