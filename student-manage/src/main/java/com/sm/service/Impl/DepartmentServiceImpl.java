package com.sm.service.Impl;


import com.sm.dao.CClassDAO;
import com.sm.dao.DepartmentDAO;
import com.sm.dao.StudentDAO;
import com.sm.entity.Department;
import com.sm.factory.DAOFactory;
import com.sm.service.DepartmentService;
import com.sm.utils.JDBCUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDAO departmentDAO = DAOFactory.getDepartmentInstance();
    private CClassDAO cClassDAO = DAOFactory.getCClassDAOInstance();
    private StudentDAO studentDAO = DAOFactory.getStudentDAOInstance();

    @Override
    public List<Department> selectAll() {
        List<Department> departmentList = null;
        try {
            departmentList = departmentDAO.getAll();
        } catch (SQLException e) {
            System.err.print("查询院系信息出现异常");
        }
        return departmentList;
    }

    @Override
    public void deledeDapartment(int id) {
        try {
            System.out.println(departmentDAO.deleteDepartmentsById(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertDepartment(Department department) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "INSERT INTO t_department (department_name,logo) VALUES (?,?) ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, department.getDepartmentName());
        pstmt.setString(2, department.getLogo());
        int n = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }

    @Override
    public int addDepartment(Department department) {
        int n = 1;
        try {
            n = departmentDAO.insertDepartment(department);
        } catch (SQLException e) {
            System.err.print("新增院系信息出现异常");
        }
        return n;
    }

    @Override
    public List<Map> selectDepartmentInfo() {
        List<Department> departmentList = null;
        try {
            departmentList = departmentDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Map> mapList = new ArrayList<>();
        for (Department department : departmentList) {
            Map<String, Object> map = new HashMap();
            map.put("department", department);
            try {
                map.put("classCount", cClassDAO.countByDepartmentId(department.getId()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                map.put("studentCount", studentDAO.countByDepartment(department.getId()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            mapList.add(map);
        }
        return mapList;
    }
}