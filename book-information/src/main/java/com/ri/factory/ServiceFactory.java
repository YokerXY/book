package com.ri.factory;

import com.ri.service.AdminService;
import com.ri.service.BookService;
import com.ri.service.Impl.AdminServiceImpl;
import com.ri.service.Impl.BookServiceImpl;
import com.ri.service.Impl.ReaderInformationServiceImpl;
import com.ri.service.Impl.StudentServiceImpl;
import com.ri.service.ReaderInformationSeervice;
import com.ri.service.StudentService;

public class ServiceFactory {

    public static AdminService getAdminServiceInstance() {
        return new AdminServiceImpl();
    }
    public static StudentService getStudentServiceInstance() {
        return new StudentServiceImpl();
    }
//
//    public static StudentFrameService getStudentFrameServiceInstance() {
//        return new StudentFrameServiceImpl();
//    }
//
//    public static TypeService getTypeServiceInstance() {
//        return new TypeServiceImpl();
//    }
     public static ReaderInformationSeervice getReaderServiceInstance(){
        return  new ReaderInformationServiceImpl();
        }
        public  static BookService getBookServiceInstance(){
        return  new BookServiceImpl();
        }
     }
