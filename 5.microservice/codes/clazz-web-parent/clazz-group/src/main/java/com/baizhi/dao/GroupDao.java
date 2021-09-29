package com.baizhi.dao;


import com.baizhi.entity.Group;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupDao {

    //小组列表
    List<Group> queryAll();

    //添加小组
    int insert(Group group);

    //小组信息
    Group queryById(Integer id);

}

