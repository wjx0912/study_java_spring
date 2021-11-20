package com.baizhi.entity;

import java.io.Serializable;


public class StudentTag implements Serializable {
    private static final long serialVersionUID = -21307510919031598L;

    private Integer sid;

    private Integer tid;


    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public StudentTag() {
    }

    public StudentTag(Integer sid, Integer tid) {
        this.sid = sid;
        this.tid = tid;
    }
}

