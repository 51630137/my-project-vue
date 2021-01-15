package com.jg.myprojectvue.mapper;

import com.jg.myprojectvue.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DepartmentMapper {
    /**
     * 查询部门列表
     * @return
     */
    List<Department> departmentLst();
}
