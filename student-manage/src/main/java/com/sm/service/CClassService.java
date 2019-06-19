package com.sm.service;

import com.sm.entity.CClass;

import java.util.List;

public interface CClassService {
    /**
     *
     * @param departmentId
     * @return
     */
    List<CClass> selectByDepartmentId(int departmentId);

    /**
     * 新增班级
     * @param cClass
     * @return
     */
    int addCClass (CClass cClass);

    /**
     * 删除班级
     * @param id
     */
    void deleteCClass(int id);

    List<CClass> selectAll();
}
