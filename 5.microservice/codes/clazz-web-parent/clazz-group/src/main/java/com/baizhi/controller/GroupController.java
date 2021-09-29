package com.baizhi.controller;

import com.baizhi.entity.Group;
import com.baizhi.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("groups")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    //小组列表
    @GetMapping
    public List<Group> groups() {
        return groupService.queryAll();
    }

    //添加小组
    @PostMapping
    public void create(@RequestBody Group group) {
        groupService.insert(group);
    }

    //小组信息
    @GetMapping("{id}")
    public Group group(@PathVariable("id") Integer id) {
        return groupService.queryById(id);
    }

}

