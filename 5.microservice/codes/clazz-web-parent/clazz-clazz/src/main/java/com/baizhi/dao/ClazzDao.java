package com.baizhi.dao;

import com.baizhi.entity.Clazz;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ClazzDao {

    //查询班级列表
    List<Clazz> queryAll();

    //添加班级信息
    void insert(Clazz clazz);

    //删除班级信息
    int delete(Integer id);

    //班级信息
    Clazz queryById(Integer id);

}
