package com.sm.service.Impl;

import com.sm.entity.ResultEntity;
import com.sm.factory.ServiceFactory;
import com.sm.service.AdminService;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminServiceImplTest {
    private AdminService adminService = ServiceFactory.getAdminServiceInstance();
    @Test
    public void adminLogin() {
        ResultEntity resultEntity = adminService.adminLogin("xyz.qq.com", "111");
        System.out.println(resultEntity);

    }
}