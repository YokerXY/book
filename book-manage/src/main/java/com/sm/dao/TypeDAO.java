package com.sm.dao;

import com.sm.entity.Book;
import com.sm.entity.Type;

import java.sql.SQLException;
import java.util.List;

public interface TypeDAO {
    List<Type> selectAll() throws SQLException;

    /**
     * 通过班级id查询类别
     * @param typeId
     * @return
     * @throws SQLException
     */
    List<Type> selectByTypeId(int typeId) throws SQLException;
    int insertType(Type type) throws SQLException;
    int deleteTypes(Integer id) throws SQLException;
    List<Book>  selectByBookId(int typeId) throws  SQLException;
    int countBookByTypeId(int typeId) throws SQLException;
}
