package com.jg.myprojectvue.service.impl;

import com.jg.myprojectvue.mapper.DepartmentMapper;
import com.jg.myprojectvue.pojo.Department;
import com.jg.myprojectvue.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> departmentLst() {
        return departmentMapper.departmentLst();
    }
}
