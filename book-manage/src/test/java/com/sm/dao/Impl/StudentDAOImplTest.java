package com.sm.dao.Impl;

import com.sm.dao.StudentDAO;
import com.sm.entity.StuLogin;
import com.sm.factory.DAOFactory;
import org.junit.Test;
import java.sql.SQLException;
public class StudentDAOImplTest {
   private StudentDAO studentDAO  = DAOFactory.getStudentDAOInstance();
    @Test
    public void getStuLoginByAccount() {
        try {
            StuLogin stuLogin = studentDAO.getStuLoginByAccount("1314520");
            if (stuLogin != null) {
                System.out.println(stuLogin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}