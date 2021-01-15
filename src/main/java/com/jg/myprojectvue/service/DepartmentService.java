package com.jg.myprojectvue.service;

import com.jg.myprojectvue.pojo.Department;

import java.util.List;

public interface DepartmentService {
    /**
     * 查询部门列表
     * @return
     */
    List<Department> departmentLst();
}
