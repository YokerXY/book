package com.sm.entity;

import java.util.Date;

public class Reader {
    private Integer id;
    private Integer class_id;
    private String name;
    private String role;
    private String avatar;
    private java.util.Date join_date;
    private String email;
    private String mobile;

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", class_id=" + class_id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", avatar='" + avatar + '\'' +
                ", join_date=" + join_date +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
