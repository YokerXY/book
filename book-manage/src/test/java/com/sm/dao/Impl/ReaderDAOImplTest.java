package com.sm.dao.Impl;

import com.sm.dao.ReaderDAO;
import com.sm.entity.Reader;
import com.sm.entity.ReaderVO;
import com.sm.factory.DAOFactory;
import org.junit.Test;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ReaderDAOImplTest {
    private ReaderDAO readerDAO = DAOFactory.getReaderDAOInstance();

    @Test
    public void selectAll() {
        List<ReaderVO> readerVOList = null;
        try {
            readerVOList = readerDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        readerVOList.forEach(ReaderVO -> System.out.println(ReaderVO));

    }

    @Test
    public void selectByTypeId() {
        List<ReaderVO> readerVOList = null;
        try {
            readerVOList = readerDAO.selectByTypeId(3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        readerVOList.forEach(readerVO -> System.out.println(readerVO));
    }

    @Test
    public void selectByClassId() {
        List<ReaderVO> readerVOList = null;
        try {
            readerVOList = readerDAO.selectByClassId(3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        readerVOList.forEach(readerVO -> System.out.println(readerVO));
    }

    @Test
    public void selectByKeywords() {
        List<ReaderVO> readerVOList = null;
        try {
            readerVOList = readerDAO.selectByKeywords("王");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        readerVOList.forEach(readerVO -> System.out.println(readerVO));

    }

    @Test
    public void updateReader() throws SQLException {
        Reader reader = new Reader();
        reader.setId(8);
        reader.setEmail("333@qq.com");
        reader.setMobile("123321");
        int n = readerDAO.updateReader(reader);
        assertEquals(1, n);

    }

    @Test
    public void deleteById() throws SQLException {
        String id = "9";
        readerDAO.deleteById(id);

    }

    @Test
    public void insertReader() throws SQLException{
        Reader reader = new Reader();
        reader.setId(9);
        reader.setClass_id(9);
        reader.setName("安楠");
        reader.setRole("女");
        reader.setAvatar("http://pj7ldvis7.bkt.clouddn.com/avatar/1.jpg");
        reader.setJoin_date(new Date(2018-2-12));
        reader.setEmail("444@qq.com");
        reader.setMobile("123321");
        int n = readerDAO.insertReader(reader);
        assertEquals(1, n);

    }

    @Test
    public void countByTypeId() {
        try {
            int n = readerDAO.countByTypeId(1);
            System.err.println(n);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}