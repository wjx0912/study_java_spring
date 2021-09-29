package com.baizhi.dao;

import com.baizhi.entity.StudentTag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentTagDao {

    //保存学生标签信息
    int insert(StudentTag studentTag);

    //获取学生标签列表
    List<Integer> queryByStudentId(Integer studentId);

}

