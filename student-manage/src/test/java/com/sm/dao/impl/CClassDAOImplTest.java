package com.sm.dao.impl;

import com.sm.dao.CClassDAO;
import com.sm.entity.CClass;
import com.sm.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
public class CClassDAOImplTest {
     private CClassDAO cClassDAO = DAOFactory.getCClassDAOInstance();
    @Test
    public void selectByDepartmentId() {
        List<CClass> cClassList = null;
        try {
            cClassList= cClassDAO.selectByDepartmentId(4);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cClassList.forEach(department -> System.out.println(department));
    }

    @Test
    public void insertCClass() throws SQLException {
        CClass cClass = new CClass();
        cClass.setDepartmentId(5);
        cClass.setClassName("软件1844班");
        int n = cClassDAO.insertCClass(cClass);


    }

    @Test
    public void deleteById() throws SQLException {
        System.out.println(cClassDAO.deleteById(17));
    }

    @Test
    public void selectAll() {
     List<CClass> cClassList = null;
     try {
         cClassList = cClassDAO.selectAll();
     }catch ( SQLException e){
         e.printStackTrace();
     }
     cClassList.forEach(cClass -> System.out.println(cClass));
    }

    @Test
    public void countByDepartmentId()throws  SQLException {
     int n = cClassDAO.countByDepartmentId(2);
        System.out.println(n);
    }
}