package com.baizhi.test;


import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class TestUserService  extends BasicTest{


    @Autowired
    private UserService userService;


    @Test
    public void testSave(){
        User user = new User();
        user.setName("小明123");
        user.setAge(23);
        user.setSalary(2300.2);
        userService.save(user);
    }

    //findAll
    @Test
    public void testFindAll(){
        userService.findAll().forEach(user-> System.out.println(user));
    }
}
