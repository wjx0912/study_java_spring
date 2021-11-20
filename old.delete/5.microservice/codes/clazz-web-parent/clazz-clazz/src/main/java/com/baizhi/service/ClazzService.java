package com.baizhi.service;

import com.baizhi.entity.Clazz;

import java.util.List;

public interface ClazzService {

    //查询班级列表
    List<Clazz> queryAll();

    //添加班级
    Clazz insert(Clazz clazz);

    //删除班级信息
    void delete(Integer id);

    //班级信息
    Clazz queryById(Integer id);

}
