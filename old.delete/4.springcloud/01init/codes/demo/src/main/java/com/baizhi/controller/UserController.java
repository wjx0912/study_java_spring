package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    //定义日志对象
    //private static Logger log = LoggerFactory.getLogger(UserController.class);

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    /**
     * 修改用户信息
     */
    @RequestMapping("update")
    public String update(User user){
        //System.out.println("修改的用户信息: "+user);
        log.debug("修改的用户信息: [{}] [{}]",user,"这是站位");
        userService.update(user);
        return "redirect:/user/findAll";
    }

    /**
     * 查询一个
     */
    @RequestMapping("findById")
    public String findById(Integer id,Model model){
        //System.out.println("id: "+id);
        log.debug("id:"+id);
        User user = userService.findById(id);
        model.addAttribute("user",user);
        return "showOne";
    }

    /**
     * 添加用户
     */
    @RequestMapping("save")
    public String save(String name,User user){
//        System.out.println("name: "+ name);
//        System.out.println("user: "+user);
        log.debug("name: "+name);
        log.debug("user: " +user);
        userService.save(user);
        return "redirect:/user/findAll";
    }

    /**
     * 查询所有
     */
    @RequestMapping("findAll")
    public String findAll(HttpServletRequest request, Model model){
        List<User> users = userService.findAll();
        log.debug("返回的总条数: "+users.size());
        //保存到作用域
        model.addAttribute("users",users);
        return "showAll";
    }
}
