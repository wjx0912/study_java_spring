package com.baizhi.entity;

import java.io.Serializable;

/**
 * (Clazz)实体类
 *
 * @author makejava
 * @since 2021-09-12 18:02:25
 */
public class Clazz implements Serializable {
    private static final long serialVersionUID = -98210032670644857L;

    private Integer id;

    private String name;

    private String path;

    private Integer tagId;

    private Tag tag;//标签对象

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", tagId=" + tagId +
                '}';
    }

    public Clazz() {
    }

    public Clazz(Integer id, String name, String path, Integer tagId) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.tagId = tagId;
    }
}

