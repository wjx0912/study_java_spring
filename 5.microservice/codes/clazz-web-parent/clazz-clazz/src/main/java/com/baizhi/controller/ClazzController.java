package com.baizhi.controller;

import com.baizhi.entity.Clazz;
import com.baizhi.service.ClazzService;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    private static final Logger log = LoggerFactory.getLogger(ClazzController.class);
    private final ClazzService clazzService;

    @Autowired
    public ClazzController(ClazzService clazzService) {
        this.clazzService = clazzService;
    }

    @Value("${upload.dir}")
    private String realpath;

    //添加班级
    @PostMapping
    public Clazz create(String name, MultipartFile logo, Integer tagId) throws IOException {
        log.debug("班级名称: {}", name);
        log.debug("logo文件名称: {}", logo.getOriginalFilename());
        log.debug("标签id: {}", tagId);
        //1.处理文件上传 & 修改文件名称
        String newFileName =
                UUID.randomUUID().toString().replace("-", "") + "." +
                        FilenameUtils.getExtension(logo.getOriginalFilename());

        log.debug("新文件名称为:{}", newFileName);
        logo.transferTo(new File(realpath, newFileName));

        //2.保存班级信息
        Clazz clazz = new Clazz();
        clazz.setName(name);
        clazz.setTagId(tagId);
        clazz.setPath(newFileName); //赋值文件名称
        return clazzService.insert(clazz);
    }

    //班级列表接口
    @GetMapping
    public List<Clazz> clazzs() {
        return clazzService.queryAll();
    }

    //删除班级
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        clazzService.delete(id);
    }


    //班级详细
    @GetMapping("{id}")
    public Clazz clazz(@PathVariable Integer id) {
        return clazzService.queryById(id);
    }
}
