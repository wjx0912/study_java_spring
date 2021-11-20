package com.baizhi.controller;

import com.baizhi.dto.StudentRequestDTO;
import com.baizhi.dto.StudentResponseDTO;
import com.baizhi.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //学生列表
    @GetMapping
    public List<StudentResponseDTO> students() {
        return studentService.queryAll();
    }

    //添加学生列表
    @PostMapping
    public StudentResponseDTO create(@RequestBody StudentRequestDTO studentRequestDTO) {
        log.info("班级id: {}", studentRequestDTO.getClazzId());
        log.info("城市id: {}", studentRequestDTO.getCityId());
        log.info("小组id: {}", studentRequestDTO.getGroupId());
        if (studentRequestDTO.getTagIds() != null) {
            studentRequestDTO.getTagIds().forEach(id -> log.info("标签id: {}", id));
        }
        return studentService.insert(studentRequestDTO);
    }

}
