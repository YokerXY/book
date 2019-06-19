package com.sm.dao.impl;

import com.sm.dao.StudentDAO;
import com.sm.entity.Student;
import com.sm.entity.StudentPunishments;
import com.sm.entity.StudentRewards;
import com.sm.entity.StudentVO;
import com.sm.utils.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public List<StudentVO> selectAll() throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.*,t2.class_name,t3.department_name\n" +
                "FROM t_student t1\n" +
                "LEFT JOIN t_class t2\n" +
                "ON t1.class_id=t2.id\n" +
                "LEFT JOIN t_department t3\n" +
                "ON t2.department_id=t3.id";
        PreparedStatement psmt = connection.prepareStatement(sql);
        ResultSet rs = psmt.executeQuery();
        List<StudentVO> studentList = convert(rs);
        rs.close();
        psmt.close();
        jdbcUtil.closeConnection();
        return studentList;
    }

    @Override
    public List<StudentVO> selectByDepartmentId(int departmentId) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.*,t2.class_name,t3.department_name\n" +
                "FROM t_student t1\n" +
                "LEFT JOIN t_class t2\n" +
                "ON t1.class_id=t2.id\n" +
                "LEFT JOIN t_department t3\n" +
                "ON t2.department_id=t3.id\n" +
                "WHERE t3.id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, departmentId);
        ResultSet rs = pstmt.executeQuery();
        List<StudentVO> studentList = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return studentList;
    }

    @Override
    public List<StudentVO> selectByClassId(int classId) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.*,t2.class_name,t3.department_name\n" +
                "FROM t_student t1\n" +
                "LEFT JOIN t_class t2\n" +
                "ON t1.class_id=t2.id\n" +
                "LEFT JOIN t_department t3\n" +
                "ON t2.department_id=t3.id\n" +
                "WHERE t1.class_id =?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, classId);
        ResultSet rs = pstmt.executeQuery();
        List<StudentVO> studentList = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return studentList;
    }

    @Override
    public List<StudentVO> selectByKeywords(String keywords) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.*,t2.class_name,t3.department_name\n" +
                "FROM t_student t1\n" +
                "LEFT JOIN t_class t2\n" +
                "ON t1.class_id=t2.id\n" +
                "LEFT JOIN t_department t3\n" +
                "ON t2.department_id=t3.id\n" +
                "WHERE t1.student_name LIKE ? OR t1.address LIKE ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, "%" + keywords + "%");
        pstmt.setString(2, "%" + keywords + "%");
        ResultSet rs = pstmt.executeQuery();
        List<StudentVO> studentList = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return studentList;
    }

    @Override
    public int updateStudent(Student student) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "UPDATE t_student SET address = ?,phone = ? WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, student.getAddress());
        pstmt.setString(2, student.getPhone());
        pstmt.setString(3, student.getId());
        int n = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }

    @Override
    public int deleteById(String id) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "DELETE FROM t_student WHERE id =?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, id);
        int n = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }

    @Override
    public int insertStudent(Student student) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "INSERT INTO t_student VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, student.getId());
        pstmt.setInt(2, student.getClassId());
        pstmt.setString(3, student.getStudentName());
        pstmt.setString(4, student.getAvatar());
        pstmt.setString(5, student.getGender());
        pstmt.setDate(6, new Date(student.getBirthday().getTime()));
        pstmt.setString(7, student.getAddress());
        pstmt.setString(8, student.getPhone());
        int n = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }

    @Override
    public int countByDepartment(int departmentId) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT COUNT(*) \n" +
                "FROM t_student t1\n" +
                "LEFT JOIN t_class t2\n" +
                "ON t1.class_id=t2.id\n" +
                "LEFT JOIN t_department t3\n" +
                "ON t2.department_id=t3.id\n" +
                "WHERE t3.id = ?";
        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setInt(1, departmentId);
        ResultSet rs = psmt.executeQuery();
        int rowCount = 0;
        if (rs.next()) {
            rowCount = rs.getInt(1);
        }
        rs.close();
        psmt.close();
        jdbcUtil.closeConnection();
        return rowCount;
    }

    @Override
    public int countByClassId(int classId) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT COUNT(*) FROM t_student  WHERE class_id=? ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, classId);
        ResultSet rs = pstmt.executeQuery();
        int rowCount = 0;
        if (rs.next()) {
            rowCount = rs.getInt(1);
        }
        return rowCount;
    }

    @Override
    public List<StudentRewards> selectAllRewards() throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.id,t1.student_name,t1.gender,t2.class_name,t3.department_name,t4.rewards,t4.rewardsDate\n" +
                "FROM t_student t1\n" +
                "LEFT JOIN t_class t2\n" +
                "ON t1.`class_id` = t2.`id`\n" +
                "LEFT JOIN t_department t3\n" +
                "ON t2.`department_id` = t3.`id`\n" +
                "LEFT JOIN t_rewards t4 \n" +
                "ON t4.`id` = t1.`id`\n";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<StudentRewards> studentList = new ArrayList<>();
        while (rs.next()) {
            StudentRewards student = new StudentRewards();
            student.setId(rs.getString("id"));
            student.setStudentName(rs.getString("student_name"));
            student.setGender(rs.getString("gender"));
            student.setRewards(rs.getString("rewards"));
            student.setDepartmentName(rs.getString("department_name"));
            student.setClassName(rs.getString("class_name"));
            student.setRewardsDate(rs.getDate("rewardsDate"));
            studentList.add(student);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return studentList;
    }

    @Override
    public List<StudentPunishments> selectAllPunishments() throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t4.`primary_id`,t1.id,t1.student_name,t1.gender,t2.class_name,t3.department_name,t4.`punishments`,t4.`punishmentsDate`\n" +
                "FROM t_student t1\n" +
                "LEFT JOIN t_class t2\n" +
                "ON t1.`class_id` = t2.`id`\n" +
                "LEFT JOIN t_department t3\n" +
                "ON t2.`department_id` = t3.`id`\n" +
                "LEFT JOIN t_punishments t4 \n" +
                "ON t4.`id` = t1.`id`";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<StudentPunishments> studentList = new ArrayList<>();
        while (rs.next()) {
            StudentPunishments student = new StudentPunishments();
            student.setId(rs.getString("id"));
            student.setStudentName(rs.getString("student_name"));
            student.setGender(rs.getString("gender"));
            student.setPunishments(rs.getString("punishments"));
            student.setDepartmentName(rs.getString("department_name"));
            student.setClassName(rs.getString("class_name"));
            student.setPunishmentsDate(rs.getDate("punishmentsDate"));
            studentList.add(student);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return studentList;
    }

    @Override
    public List<StudentPunishments> selectPunishmentsByPrimaryId(int primaryId) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t4.*\n" +
                "FROM t_punishments t4\n" +
                "WHERE t4.`primary_id`= ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, primaryId);
        ResultSet rs = pstmt.executeQuery();
        List<StudentPunishments> students = convert3(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return students;
    }

    @Override
    public List<StudentRewards> selectRewardsById(String id) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.id,t1.student_name,t1.gender,t2.class_name,t3.department_name,t4.rewards,t4.`primary_id`,t4.rewardsDate\n" +
                "FROM t_student t1\n" +
                "LEFT JOIN t_class t2\n" +
                "ON t1.`class_id` = t2.`id`\n" +
                "LEFT JOIN t_department t3\n" +
                "ON t2.`department_id` = t3.`id`\n" +
                "LEFT JOIN t_rewards t4 \n" +
                "ON t4.`id` = t1.`id`\n" +
                "WHERE t4.`id` = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();
        List<StudentRewards> students = convert1(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return students;
    }

    @Override
    public List<StudentPunishments> selectPunishmentsById(String id) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.id,t1.student_name,t1.gender,t2.class_name,t3.department_name,t4.`punishments`,t4.`primary_id`,t4.`punishmentsDate`\n" +
                "FROM t_student t1\n" +
                "LEFT JOIN t_class t2\n" +
                "ON t1.`class_id` = t2.`id`\n" +
                "LEFT JOIN t_department t3\n" +
                "ON t2.`department_id` = t3.`id`\n" +
                "LEFT JOIN t_punishments t4 \n" +
                "ON t4.`id` = t1.`id`\n" +
                "WHERE t4.`id`= ?\n";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();
        List<StudentPunishments> students = convert2(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return students;
    }

    @Override
    public int insertRewards(StudentRewards rewards) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "INSERT INTO t_rewards VALUES (?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, rewards.getPrimaryId());
        pstmt.setString(2, rewards.getId());
        pstmt.setString(3, rewards.getRewards());
        pstmt.setDate(4, new java.sql.Date(rewards.getRewardsDate().getTime()));
        int n = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }

    @Override
    public int insertPunishments(StudentPunishments punishments) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "INSERT INTO t_punishments VALUES (?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, punishments.getPrimaryId());
        pstmt.setString(2, punishments.getId());
        pstmt.setString(3, punishments.getPunishments());
        pstmt.setDate(4, new java.sql.Date(punishments.getPunishmentsDate().getTime()));
        int n = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }

    @Override
    public int deletePunishmentsByPrimaryId(int primaryId) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "DELETE FROM t_punishments WHERE primary_id = ?";
        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setInt(1, primaryId);
        int n = psmt.executeUpdate();
        connection.close();
        return n;
    }

    @Override
    public int countPunishments() throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT COUNT(*) FROM t_punishments";
        PreparedStatement psmt = connection.prepareStatement(sql);
        ResultSet rs = psmt.executeQuery();
        int punishmentsCount = 0;
        if (rs.next()){
            punishmentsCount = rs.getInt(1);
        }
        rs.close();
        psmt.close();
        jdbcUtil.closeConnection();
        return punishmentsCount;
    }

    @Override
    public int countRewards() throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT COUNT(*) FROM t_rewards";
        PreparedStatement psmt = connection.prepareStatement(sql);
        ResultSet rs = psmt.executeQuery();
        int rewardsCount = 0;
        if (rs.next()){
            rewardsCount = rs.getInt(1);
        }
        rs.close();
        psmt.close();
        jdbcUtil.closeConnection();
        return rewardsCount;
    }

    private List<StudentVO> convert(ResultSet rs) throws SQLException {
        List<StudentVO> studentVOList = new ArrayList<>();
        while (rs.next()) {
            StudentVO student = new StudentVO();
            student.setId(rs.getString("id"));
            student.setDepartmentName(rs.getString("department_name"));
            student.setClassName(rs.getString("class_name"));
            student.setStudentName(rs.getString("student_name"));
            student.setAvatar(rs.getString("avatar"));
            student.setGender(rs.getString("gender"));
            student.setBirthday(rs.getDate("birthday"));
            student.setAddress(rs.getString("address"));
            student.setPhone(rs.getString("phone"));
            studentVOList.add(student);
        }
        return studentVOList;
    }

    private List<StudentRewards> convert1(ResultSet rs) throws SQLException {
        List<StudentRewards> students = new ArrayList<>();
        while (rs.next()) {
            StudentRewards studentRewards = new StudentRewards();
            studentRewards.setPrimaryId(rs.getInt("primary_id"));
            studentRewards.setId(rs.getString("id"));
            studentRewards.setStudentName(rs.getString("student_name"));
            studentRewards.setGender(rs.getString("gender"));
            studentRewards.setClassName(rs.getString("class_name"));
            studentRewards.setDepartmentName(rs.getString("department_name"));
            studentRewards.setRewards(rs.getString("rewards"));
            studentRewards.setRewardsDate(rs.getDate("rewardsDate"));
            students.add(studentRewards);
        }
        return students;
    }

    private List<StudentPunishments> convert2(ResultSet rs) throws SQLException {
        List<StudentPunishments> students = new ArrayList<>();
        while (rs.next()) {
            StudentPunishments studentPunishments = new StudentPunishments();
            studentPunishments.setPrimaryId(rs.getInt("primary_id"));
            studentPunishments.setId(rs.getString("id"));
            studentPunishments.setStudentName(rs.getString("student_name"));
            studentPunishments.setGender(rs.getString("gender"));
            studentPunishments.setClassName(rs.getString("class_name"));
            studentPunishments.setDepartmentName(rs.getString("department_name"));
            studentPunishments.setPunishments(rs.getString("punishments"));
            studentPunishments.setPunishmentsDate(rs.getDate("punishmentsDate"));
            students.add(studentPunishments);
        }
        return students;
    }
    private List<StudentPunishments> convert3(ResultSet rs)throws SQLException{
        List<StudentPunishments> students = new ArrayList<>();
        while (rs.next()){
            StudentPunishments studentPunishments = new StudentPunishments();
            studentPunishments.setPrimaryId(rs.getInt("primary_id"));
            studentPunishments.setId(rs.getString("id"));
            studentPunishments.setPunishments(rs.getString("punishments"));
            studentPunishments.setPunishmentsDate(rs.getDate("punishmentsDate"));
            students.add(studentPunishments);
        }
        return  students;
    }
}
