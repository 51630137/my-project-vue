package com.jg.myprojectvue;

import com.jg.myprojectvue.controller.UserController;
import com.jg.myprojectvue.pojo.User;
import com.jg.myprojectvue.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyProjectVueApplicationTests {
    @Autowired
    private UserController userController;
    @Test
    void contextLoads() {
        User user=new User();
        user.setUserName("jg");
        user.setUserAge(15);
        user.setUserSex(1);
        user.setUserBirthday("2011-12-12 12:12:12");
        user.setUserDepartment(1);
    userController.save(user);
    }

}
