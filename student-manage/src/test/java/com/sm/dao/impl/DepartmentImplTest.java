package com.sm.dao.impl;

import com.sm.dao.DepartmentDAO;
import com.sm.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class DepartmentImplTest {

    private DepartmentDAO departmentDAO = DAOFactory.deleteDepartmentDAOIbstant();
    @Test
    public void deleteDepartmentsById() {
        try {
            System.out.println(departmentDAO.deleteDepartmentsById(7));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}