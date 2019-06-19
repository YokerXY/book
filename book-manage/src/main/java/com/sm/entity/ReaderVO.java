package com.sm.entity;

import java.util.Date;

public class ReaderVO {
    private String id;
    private String bookName;
    private String typeName;
    private String name;
    private String role;
    private String avatar;
    private java.util.Date join_date;
    private String email;
    private String mobile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    @Override
    public String toString() {
        return "ReaderVO{" +
                "id='" + id + '\'' +
                ", bookName='" + bookName + '\'' +
                ", typeName='" + typeName + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", avatar='" + avatar + '\'' +
                ", join_date=" + join_date +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
