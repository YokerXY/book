package com.sm.service;

import com.sm.entity.Department;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    List<Department> selectAll();
    void deledeDapartment( int id);

    /**
     * 新增院系
     * @param department
     * @return
     * @throws SQLException
     */
    int insertDepartment(Department department) throws SQLException;

    /**
     * 新增院系
     * @param department
     * @return int
     */
    int addDepartment(Department department);
    List<Map> selectDepartmentInfo();
}
