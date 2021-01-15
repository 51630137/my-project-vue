package com.jg.myprojectvue.controller;

import com.jg.myprojectvue.pojo.User;
import com.jg.myprojectvue.service.UserService;
import com.jg.myprojectvue.util.Page;
import com.jg.myprojectvue.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/ceshi")
    public String sd(){
        return "ceshi ok!";
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public Result get(@PathVariable String id){
        User user= userService.getById(id);
        return new Result(user);
    }
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public Result save(@RequestBody User user){
        try {
            userService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(400,"保存shibai");
        }
        return new Result("保存成功");
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id){
        try {
            userService.deleteByID(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(400,"删除失败");
        }
        return new Result("删除成功");
    }
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public Result update(@RequestBody User user){
        try {
            userService.updateById(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(400,"更新失败");
        }
        return new Result("更新成功");
    }
    @RequestMapping(value = "/page",method = RequestMethod.POST)
    public Result getByPage(@RequestBody Page<User> page){
        page=userService.getByPage(page);
        return new Result(page);
    }
}
