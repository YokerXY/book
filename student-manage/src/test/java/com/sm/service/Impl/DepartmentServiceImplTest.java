package com.sm.service.Impl;

import com.sm.entity.Department;
import com.sm.factory.ServiceFactory;
import com.sm.service.DepartmentService;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class DepartmentServiceImplTest {
    private DepartmentService departmentService = ServiceFactory.getDepartmentServiceInstance();


    @Test
    public void selectAll() {
        List<Department> departmentList = departmentService.selectAll();
        departmentList.forEach(department -> System.out.println(department));
    }

    @Test
    public void deledeDapartment() {
        int id =7 ;
        departmentService.deledeDapartment(id);
    }

    @Test
    public void insertDepartment() {
        Department department = new Department();
        department.setDepartmentName("测试院系");
        department.setLogo("https://wacwp.oss-cn-hangzhou.aliyuncs.com/logo/24ea0ab2-277e-4507-aae7-b386d82d1032.jpg ");
        try {
            int n = departmentService.insertDepartment(department);
            assertEquals(1, n);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectDepartmentInfo() {
        List<Map> mapList  = departmentService.selectDepartmentInfo();
        mapList.forEach(map -> System.out.println(map.get("department") + ","+ map.get("classCount") + "个班，" + map.get("studentCount") + "个学生"));
    }
}