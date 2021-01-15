package com.jg.myprojectvue.mapper;

import com.jg.myprojectvue.pojo.User;
import com.jg.myprojectvue.util.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {
    User getById(String id);

    void save(User user);

    void deleteByID(String id);

    void updateById(User user);

    /**
     * 分页查询
     * @param page
     * @return
     */
    List<User> getListByPage(Page<User> page);

    /**
     * 查询总数
     * @param page
     * @return
     */
    int getCountBypage(Page<User> page);
}
