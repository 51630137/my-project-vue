package com.jg.myprojectvue.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String userId;
    private String userName;
    private Integer userSex;
    private Integer userAge;
    private String userBirthday;
    private Integer userDepartment;
    private String createTime;
    private String createBy;
    private String updateTime;
    private String updateBy;
    private Integer version;
    private Integer deleted;
    private Department department;
}
