package com.baizhi.service;

import com.baizhi.entity.Group;

import java.util.List;

public interface GroupService {

    //小组列表
    List<Group> queryAll();

    //添加小组
    Group insert(Group group);

    //小组信息
    Group queryById(Integer id);
}
