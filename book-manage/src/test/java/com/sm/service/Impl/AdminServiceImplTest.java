package com.sm.service.Impl;

import com.sm.entity.Admin;
import com.sm.factory.ServiceFactory;
import com.sm.service.AdminService;
import com.sm.utils.ResultEntity;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class AdminServiceImplTest {
      private AdminService adminService = ServiceFactory.getAdminServiceInstance();
    @Test
    public void adminLogin() {
        ResultEntity resultEntity  =adminService.adminLogin("5201791","1791");
        System.out.println(resultEntity);
    }

    @Test
    public void insertGlyLogin() throws SQLException {
        Admin admin = new Admin();
        admin.setAdminName("ewrwer");
        admin.setAccount("234345");
        admin.setPassword("23434");
        adminService.insertGlyLogin(admin);
    }
}