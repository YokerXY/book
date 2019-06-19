package com.sm.dao.Impl;

import com.sm.dao.TypeDAO;
import com.sm.entity.Book;
import com.sm.entity.Type;
import com.sm.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class TypeDAOImplTest {
 private TypeDAO typeDAO = DAOFactory.getTypeDAOInstance();
    @Test
    public void selectAll() {
        List<Type> typeList = null;
        try {
            typeList = typeDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        typeList.forEach(type -> System.out.println(type));
    }

    @Test
    public void selectByTypeId() {
        List<Type> typeList = null;
        try {
            typeList = typeDAO.selectByTypeId(3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        typeList.forEach(type -> System.out.println(type));
    }

    @Test
    public void insertType() {
        Type type = new Type();
        type.setId(13);
        type.setTypeId(5);
        type.setTypeName("语文");
        try {
            int n = typeDAO.insertType(type);
            assertEquals(1,n);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteTypes()  throws SQLException{
        typeDAO.deleteTypes(9);
    }


    @Test
    public void selectByBookId() {
        List<Book> bookList = null;
        try {
            bookList = typeDAO.selectByBookId(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        bookList.forEach(book -> System.out.println(book));

    }

    @Test
    public void countBookByTypeId() throws SQLException {
        int n = typeDAO.countBookByTypeId(2);
        System.out.println(n);
    }
}