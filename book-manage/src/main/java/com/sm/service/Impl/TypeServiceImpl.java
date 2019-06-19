package com.sm.service.Impl;

import com.sm.dao.TypeDAO;
import com.sm.entity.Book;
import com.sm.entity.Type;
import com.sm.factory.DAOFactory;
import com.sm.service.TypeService;

import java.sql.SQLException;
import java.util.List;

public class TypeServiceImpl  implements TypeService {
      private TypeDAO typeDAO = DAOFactory.getTypeDAOInstance();
    @Override
    public List<Type> selectAll() {
            List<Type> typeList = null;
            try {
                typeList = typeDAO.selectAll();
            } catch (SQLException e) {
                System.err.print("查询类别信息出现异常");
            }
            return typeList;
    }

    @Override
    public List<Type> selectByTypeId(int TypeId) {
        List<Type> typeList = null;
        try {
            typeList = typeDAO.selectByTypeId(3);
        } catch (SQLException e) {
            System.err.print("查询类别信息出现异常");
        }
        return typeList;
    }

    @Override
    public List<Book> selectByBookId(int TypeId) {
        List<Book> bookList  = null;
        try {
            bookList =typeDAO.selectByBookId(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public int addType(Type type) {
        int n = 0;
        try {
            n = typeDAO.insertType(type);
        } catch (SQLException e) {
            System.err.print("新增图书出现异常");
        }
        return n;
    }

    @Override
    public void deleteType(int id) {
        try {
            typeDAO.deleteTypes(9);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int countBookByTypeId(int typeId) throws SQLException {
        int n = 0;
        try {
            n=typeDAO.countBookByTypeId(typeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }
}
