package com.ri.service;

import com.ri.entrty.Admin;
import com.ri.utils.ResultEntity;

import java.sql.SQLException;

public interface AdminService {
    ResultEntity adminLogin(String account, String password);

    int insertGlyLogin(Admin admin);
}
