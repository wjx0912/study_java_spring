package com.baizhi.service;

import com.baizhi.dao.ClazzDao;
import com.baizhi.entity.Clazz;
import com.baizhi.entity.Tag;
import com.baizhi.feign.TagClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("clazzService")
@Transactional
public class ClazzServiceImpl implements ClazzService {

    private final ClazzDao clazzDao;

    private final TagClient tagClient;

    @Autowired
    public ClazzServiceImpl(ClazzDao clazzDao, TagClient tagClient) {
        this.clazzDao = clazzDao;
        this.tagClient = tagClient;
    }

    @Override
    public List<Clazz> queryAll() {
        List<Clazz> clazzes = clazzDao.queryAll();
        // TODO 实现: 遍历班级 根据班级标签id 查询当前班级标签对象 思路: 根据班级标签id调用标签服务
        clazzes.forEach(clazz -> {
            Integer tagId = clazz.getTagId();
            Tag tag = tagClient.tag(tagId);
            clazz.setTag(tag);
        });
        return clazzes;
    }


    @Override
    public Clazz insert(Clazz clazz) {
        this.clazzDao.insert(clazz);
        return clazz;
    }

    @Override
    public void delete(Integer id) {
        clazzDao.delete(id);
    }

    @Override
    public Clazz queryById(Integer id) {
        return clazzDao.queryById(id);
    }
}
