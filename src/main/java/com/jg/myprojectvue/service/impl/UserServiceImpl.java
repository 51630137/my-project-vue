package com.jg.myprojectvue.service.impl;

import com.jg.myprojectvue.mapper.UserMapper;
import com.jg.myprojectvue.pojo.User;
import com.jg.myprojectvue.service.UserService;
import com.jg.myprojectvue.util.IdWorker;
import com.jg.myprojectvue.util.Page;
import com.jg.myprojectvue.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public User getById(String id) {
        return userMapper.getById(id);
    }

    @Override
    public void save(User user) {
        user.setUserId(idWorker.nextId()+"");
        user.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        userMapper.save(user);
    }

    @Override
    public void deleteByID(String id) {
        userMapper.deleteByID(id);
    }

    /**
     * 先查询，再更新。查询主要是查询乐观锁字段
     * 乐观锁，在程序的运行过程认为程序不会被修改
     * 直到更新才去判断数据是否被修改
     * a+1
     * @param user
     */
    @Override
    public void updateById(User user) {
        User u=userMapper.getById(user.getUserId());
        user.setVersion(u.getVersion());
        user.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        userMapper.updateById(user);
    }

    @Override
    public Page<User> getByPage(Page<User> page) {
        //计算下标
        Integer pageNumber = page.getPageNumber();
        if(pageNumber==null){
            pageNumber=1;
            page.setPageNumber(1);
        }
        Integer pageSize = page.getPageSize();
        if(pageSize==null){
            pageSize=10;
            page.setPageSize(10);
        }
        int index = (pageNumber - 1) * pageSize;
        page.setIndex(index);

        //处理排序方法
        String sortMethod = page.getSortMethod();
        if(sortMethod!=null && !"".equals(sortMethod)){
            if(sortMethod.toLowerCase().contains("desc")){
                sortMethod="desc";
            }else {
                sortMethod="asc";
            }
        }
        page.setSortMethod(sortMethod);
        String sortColumn = page.getSortColumn();
        if(sortColumn!=null && !"".equals(sortColumn)){
            sortColumn= StringUtils.upperCharToUnderLine(sortColumn);
            page.setSortColumn(sortColumn);
        }

        List<User> userList= userMapper.getListByPage(page);
        int count=userMapper.getCountBypage(page);

        page.setList(userList);
        page.setTotalCount(count);
        int totalPage = (int) Math.ceil(count * 1.0 / pageSize);
        page.setTotalPage(totalPage);
        System.out.println(count);
        System.out.println(totalPage);
        return page;
    }
}
