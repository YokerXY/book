package com.sm.factory;

import com.sm.service.*;
import com.sm.service.Impl.*;

public class ServiceFactory {
    public static StudentService getStudentServiceInstance() {
        return new StudentServiceImpl();
    }

    public static AdminService getAdminServiceInstance() {
        return new AdminServiceImpl();
    }

    public static StudentFrameService getStudentFrameServiceInstance() {
        return new StudentFrameServiceImpl();
    }

    public static TypeService getTypeServiceInstance() {
        return new TypeServiceImpl();
    }
     public static ReaderServiceImpl getReaderServiceInstance(){
        return  new ReaderServiceImpl();
        }
        public  static  BookService getBookServiceInstance(){
        return  new BookServiceImpl();
        }
     }
