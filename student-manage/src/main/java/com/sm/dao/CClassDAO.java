package com.sm.dao;

import com.sm.entity.CClass;

import java.sql.SQLException;
import java.util.List;

public interface CClassDAO {
    /**
     * 按照院系ID查询班级
     * @param departmentId
     * @return   List<CClass>
     * @throws SQLException
     */


    List<CClass> selectByDepartmentId(int departmentId) throws SQLException;

    /**
     * 查询所有班级
      * @return List<CClass>
     * @throws SQLException
     */
    List<CClass> selectAll() throws  SQLException;

    /**
     * 新增院系
     * @param cClass
     * @return  int
     * @throws SQLException
     */
    int insertCClass (CClass cClass) throws  SQLException;

    /**
     * 根据班级Id删除
     * @param id
     * @return
     * @throws SQLException
     */
    int deleteById(int id)throws SQLException;



int countByDepartmentId(int departmentId) throws  SQLException;
}
