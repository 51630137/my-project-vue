package com.jg.myprojectvue.controller;

import com.jg.myprojectvue.pojo.Department;
import com.jg.myprojectvue.service.DepartmentService;
import com.jg.myprojectvue.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @RequestMapping("/departmentList")
    public Result departmentList(){
        List<Department> departmentList = departmentService.departmentLst();
        return new Result("查询成功",departmentList);
    }
}
