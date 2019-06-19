package com.sm.dao;

import com.sm.entity.StuLogin;
import com.sm.entity.Type;

import java.sql.SQLException;
import java.util.List;

public interface StudentFrameDAO {
    /**
     * 获取comobox1中的组件：t_type中的类别名
     * @return
     * @throws SQLException
     */
    List<Type> getAll() throws SQLException;

}
