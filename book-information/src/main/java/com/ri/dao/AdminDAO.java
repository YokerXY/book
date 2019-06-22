package com.ri.dao;

import com.ri.entrty.Admin;

import java.sql.SQLException;
public interface AdminDAO {
    /**
     * 根据账号查找管理员
     * @param account
     * @return  Admin
     * @throws SQLException
     */


    Admin getAdminByAccount(String account) throws SQLException;
    int insertGlyLogin(Admin admin) throws  SQLException;
}
