package com.sm.service;

import com.sm.entity.Admin;
import com.sm.utils.ResultEntity;

import java.sql.SQLException;

public interface AdminService {
    ResultEntity adminLogin(String account,String password);

    int insertGlyLogin(Admin admin) throws SQLException;
}
