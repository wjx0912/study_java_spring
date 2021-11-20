package com.baizhi.dao;

import com.baizhi.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface StudentDao {
    //学生列表
    List<Student> queryAll();

    //添加学生
    int insert(Student student);
}
