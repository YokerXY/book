package com.sm.dao.Impl;

import com.sm.dao.AdminDAO;
import com.sm.entity.Admin;
import com.sm.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class AdminDAOImplTest {
    private AdminDAO adminDAO = DAOFactory.getAdminDAOInstance();

    @Test
    public void getAdminByAccount() {
        try {
            Admin admin = adminDAO.getAdminByAccount("5201792");
            if (admin != null) {
                System.out.println(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertGlyLogin() throws  SQLException {
        Admin admin = new Admin();
        admin.setAdminName("XUSD");
        admin.setAccount("234345");
        admin.setPassword("23434");
        adminDAO.insertGlyLogin(admin);

    }
}