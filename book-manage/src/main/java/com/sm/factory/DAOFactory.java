package com.sm.factory;

import com.sm.dao.*;
import com.sm.dao.Impl.*;

public class DAOFactory {
    public static AdminDAO getAdminDAOInstance()
    { return new AdminDAOImpl();

    }
    public  static StudentDAO getStudentDAOInstance(){
        return new StudentDAOImpl();
    }
    public  static StudentFrameDAOImpl getStudentInstance(){
        return  new StudentFrameDAOImpl();
    }
    public static TypeDAO getTypeDAOInstance() {
        return new TypeDAOImpl();
    }
    public  static ReaderDAO getReaderDAOInstance(){
        return  new ReaderDAOImpl();
    }
    public  static BookDAO getBookDAOInstance(){
        return  new BookDAOImpl();
    }
}