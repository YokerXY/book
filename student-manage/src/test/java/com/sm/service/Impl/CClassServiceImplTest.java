package com.sm.service.Impl;

import com.sm.entity.CClass;
import com.sm.factory.ServiceFactory;
import com.sm.service.CClassService;
import org.junit.Test;

import java.util.List;
import java.util.zip.CheckedOutputStream;

import static org.junit.Assert.*;

public class CClassServiceImplTest {
      private CClassService cClassService = ServiceFactory.getCClassServiceInstance();
    @Test
    public void selectByDepartmentId() {
        List<CClass> cClassList = cClassService.selectByDepartmentId(4);
        cClassList.forEach(cClass -> System.out.println(cClass));
    }

    @Test
    public void addCClass() {
            CClass cClass = new CClass();
            cClass.setClassName("4256789456789");
            cClass.setDepartmentId(5);
            cClassService.addCClass(cClass);
    }

    @Test
    public void deleteCClass() {
        int id = 12;
        cClassService.deleteCClass(id);
    }

    @Test
    public void selectAll() {
            List<CClass> cClassList = cClassService.selectAll();
            cClassList.forEach(cClass -> System.out.println(cClass));

    }
}