package com.cs.yml.entity;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @author:CaoShuai
 * @dateTime:5/28/2019 11:32 AM
 * @description:
 */
public class User implements Serializable {
    private static final long serialVersionUID = -4865164769743139462L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名字
     */
    private String name;
    /**
     * 用户年龄
     */
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }
}
