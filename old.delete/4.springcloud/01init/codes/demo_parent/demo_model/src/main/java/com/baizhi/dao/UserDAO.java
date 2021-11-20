package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

public interface UserDAO {

    //查询所有
    List<User> findAll();

    //添加用户信息
    void save(User user);

    //查询一个
    User findById(Integer id);

    //修改用户信息
    void update(User user);
}
