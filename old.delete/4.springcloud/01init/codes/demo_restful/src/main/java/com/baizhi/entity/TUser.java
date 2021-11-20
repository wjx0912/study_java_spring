package com.baizhi.entity;

import java.io.Serializable;

/**
 * (TUser)实体类
 *
 * @author chenyn
 * @since 2021-04-13 11:22:02
 */
public class TUser implements Serializable {
    private static final long serialVersionUID = 548838398453003489L;

    private Integer id;

    private String name;

    private Integer age;

    private Object salary;


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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Object getSalary() {
        return salary;
    }

    public void setSalary(Object salary) {
        this.salary = salary;
    }

}
