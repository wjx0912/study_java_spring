package com.baizhi.service.impl;

import com.baizhi.dao.TagDao;
import com.baizhi.entity.Tag;
import com.baizhi.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("tagService")
@Transactional
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Override
    public List<Tag> queryAll() {
        return this.tagDao.queryAll();
    }

    @Override
    public Tag insert(Tag tag) {
        //设置创建时间
        tag.setCreatedate(new Date());
        this.tagDao.insert(tag);
        return tag;  //直接返回
    }

    @Override
    public void deleteById(Integer id) {
        this.tagDao.deleteById(id);
    }

    @Override
    public Tag queryById(Integer id) {
        return this.tagDao.queryById(id);
    }
}
