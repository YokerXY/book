package com.sm.service;

import com.sm.entity.Book;
import com.sm.entity.Type;

import java.sql.SQLException;
import java.util.List;

public interface TypeService {
    List<Type> selectAll();
    List<Type> selectByTypeId(int TypeId);
    List<Book> selectByBookId(int TypeId);

    /**
     * 增加类别
     * @param type
     * @return
     */
    int addType(Type type);

    /**
     * 删除类别
     * @param id
     */
    void deleteType(int id);
    int countBookByTypeId(int typeId) throws SQLException;
}
