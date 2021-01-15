package com.jg.myprojectvue.service;

import com.jg.myprojectvue.pojo.User;
import com.jg.myprojectvue.util.Page;

public interface UserService {
    User getById(String id);

    void save(User user);

    void deleteByID(String id);

    void updateById(User user);

    Page<User> getByPage(Page<User> page);
}
