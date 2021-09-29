package com.baizhi.service;

import com.baizhi.dto.StudentRequestDTO;
import com.baizhi.dto.StudentResponseDTO;

import java.util.List;

public interface StudentService {

    //学生列表
    List<StudentResponseDTO> queryAll();

    //添加学生
    StudentResponseDTO insert(StudentRequestDTO studentRequestDTO);
}
