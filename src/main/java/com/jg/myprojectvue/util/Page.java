package com.jg.myprojectvue.util;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
public class Page<T> {
    /**
     * 当前页
     */
    private Integer index;
    /**
     * 当前页数
     */
    private  Integer pageNumber;
    /**
     * 每页数量
     */
    private Integer PageSize;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 总条数
     */
    private Integer totalCount;
    /**
     * 数据
     */
    private List<T> list;
    /**
     * 查询的参数
     */
    private Map<String,Object> params=new HashMap<>(16);
    /**
     * 排序列
     */
    private String sortColumn;
    /**
     * 排序方式
     * 排序方式作为sql语句的关键字，因此mubatis中只能使用${}去进行拼接
     * 这么写存在严重的sql注入问题，
     * 应该在执行sql语句之前，对该字段以及排序进行过滤
     * 如果存在了可能会存在的关键字，直接将两个字段置为空
     * 可能存在注入的关键字：#，-- ，union，;,select，delete， drop
     */
    private String sortMethod;

}
