package com.sm.factory;
import com.sm.dao.StudentDAO;
import com.sm.dao.impl.StudentDAOImpl;
import com.sm.service.AdminService;
import com.sm.service.Impl.AdminServiceImpl;
import com.sm.service.DepartmentService;
import com.sm.service.CClassService;
import com.sm.service.Impl.CClassServiceImpl;
import com.sm.service.Impl.DepartmentServiceImpl;
import com.sm.service.Impl.StudentServiceImpl;
import com.sm.service.StudentService;

public class ServiceFactory {
    public static AdminService getAdminServiceInstance() {
        return new AdminServiceImpl();
    }

    public static DepartmentService getDepartmentServiceInstance() {
        return new DepartmentServiceImpl();
    }

    public static DepartmentService getDepartmentServiceImpl() {
        return new DepartmentServiceImpl();
    }

    public static CClassService getCClassServiceInstance() {
        return new CClassServiceImpl();
    }

    public static StudentService getStudentServiceInstance() {
        return new StudentServiceImpl();
    }

}
