package com.sm.service.Impl;

import com.sm.entity.Book;
import com.sm.entity.Type;
import com.sm.factory.ServiceFactory;
import com.sm.service.TypeService;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class TypeServiceImplTest {
    private TypeService typeService = ServiceFactory.getTypeServiceInstance();
    @Test
    public void selectAll() {
        List<Type> typeList = typeService.selectAll();
        typeList.forEach(type -> System.out.println(type));
    }

    @Test
    public void selectByTypeId() {
        Type type = new Type();
        type.setId(9);
        type.setTypeId(5);
        type.setTypeName("历史");
        typeService.addType(type);
    }

    @Test
    public void addType() {
        int id = 9;
        typeService.deleteType(id);
    }

    @Test
    public void deleteType() {
        List<Type> typeList = typeService.selectByTypeId(3);
        typeList.forEach(type -> System.out.println(type));
    }

    @Test
    public void selectByBookId() {
        List<Book> typeList = typeService.selectByBookId(2);
        typeList.forEach(type -> System.out.println(type));
    }

    @Test
    public void countBookByTypeId() throws SQLException {
        int n = typeService.countBookByTypeId(2);
        System.out.println(n);

    }
}