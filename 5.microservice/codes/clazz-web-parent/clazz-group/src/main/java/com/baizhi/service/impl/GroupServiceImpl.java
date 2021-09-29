package com.baizhi.service.impl;

import com.baizhi.dao.GroupDao;
import com.baizhi.entity.Clazz;
import com.baizhi.entity.Group;
import com.baizhi.feign.ClazzClient;
import com.baizhi.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("groupService")
@Transactional
public class GroupServiceImpl implements GroupService {


    private final GroupDao groupDao;


    private final ClazzClient clazzClient;

    @Autowired
    public GroupServiceImpl(GroupDao groupDao, ClazzClient clazzClient) {
        this.groupDao = groupDao;
        this.clazzClient = clazzClient;
    }

    @Override
    public List<Group> queryAll() {
        List<Group> groups = this.groupDao.queryAll();
        //TODO 调用班级服务查询每个组班级信息
        groups.forEach(group -> {
            //根据小组班级id查询对应班级信息
            Clazz clazz = clazzClient.clazz(group.getClazzId());
            group.setClazz(clazz);
        });
        return groups;
    }

    @Override
    public Group insert(Group group) {
        //设置小组创建时间
        group.setCreatedate(new Date());
        this.groupDao.insert(group);
        return group;
    }

    @Override
    public Group queryById(Integer id) {
        return groupDao.queryById(id);
    }
}
