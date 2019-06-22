package com.ri.dao.Impl;

import com.ri.dao.AdminDAO;
import com.ri.entrty.Admin;
import com.ri.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class AdminDAOImplTest   {
    private AdminDAO adminDAO = DAOFactory.getAdminDAOInstance();
    @Test
    public void insertGlyLogin() throws SQLException {
        Admin admin = new Admin();
        admin.setAdminName("XUD");
        admin.setAccount("234345");
        admin.setPassword("23434");
        adminDAO.insertGlyLogin(admin);
    }
}