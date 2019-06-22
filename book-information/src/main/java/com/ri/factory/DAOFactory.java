package com.ri.factory;

import com.ri.dao.*;
import com.ri.dao.Impl.*;

public class DAOFactory {
    public static AdminDAO getAdminDAOInstance() {
        return new AdminDAOImpl();

    }

    public static StudentDAO getStudentDAOInstance() {
        return new StudentDAOImpl();
    }

    public static BookDAO getBookDAOInstance() {
        return new BookDAOImpl();
    }

    public static ReaderInformationDAO getReaderInstance() {
        return new ReaderInformationDAOImpl();
    }

    public static StudentFrameDAO getStudentFrameDAOInstance() {
        return new StudentFrameDAOImpl();
    }

}
