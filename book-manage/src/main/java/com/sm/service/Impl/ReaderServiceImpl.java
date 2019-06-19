package com.sm.service.Impl;

import com.sm.dao.ReaderDAO;
import com.sm.entity.Reader;
import com.sm.entity.ReaderVO;
import com.sm.factory.DAOFactory;
import com.sm.service.ReaderService;

import java.sql.SQLException;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private ReaderDAO readerDAO = DAOFactory.getReaderDAOInstance();
    @Override
    public List<ReaderVO> selectAll() {
        List<ReaderVO> readerList = null;
        try {
            readerList = readerDAO.selectAll();
        } catch (SQLException e) {
            System.err.print("查询读者信息出现异常");
        }
        return readerList;
    }

    @Override
    public List<ReaderVO> selectByTypeId(int typeId) {
        List<ReaderVO> readers = null;
        try {
            readers = readerDAO.selectByTypeId(typeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return readers;
    }

    @Override
    public List<ReaderVO> selectByClassId(int classId) {
        List<ReaderVO> readers = null;
        try {
            readers = readerDAO.selectByClassId(classId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return readers;
    }

    @Override
    public List<ReaderVO> selectByKeywords(String keywords) {
        List<ReaderVO> readers = null;
        try {
            readers = readerDAO.selectByKeywords(keywords);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return readers;
    }

    @Override
    public int updateReader(Reader reader) {
        try {
            readerDAO.updateReader(reader);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void deleteReader(String id) {
        try {
            readerDAO.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertReader(Reader reader) {
        int n = 0;
        try {
            n = readerDAO.insertReader(reader);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int countReader(int classId) {
        int n = 0;
        try {
            n = readerDAO.countByTypeId(classId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }
}
