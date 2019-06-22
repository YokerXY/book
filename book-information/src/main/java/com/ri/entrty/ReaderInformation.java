package com.ri.entrty;

import java.util.Date;

public class ReaderInformation {
    private  String id ;
    private String readerName;
    private String avatar;
    private String role;
    private Date joinDate;
    private String eMail;
    private String mobile;
    private String bookName;
    private String bookAvatar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAvatar() {
        return bookAvatar;
    }

    public void setBookAvatar(String bookAvatar) {
        this.bookAvatar = bookAvatar;
    }

    @Override
    public String
    toString() {
        return "ReaderInformation{" +
                "id=" + id +
                ", readerName='" + readerName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", role='" + role + '\'' +
                ", joinDate=" + joinDate +
                ", eMail='" + eMail + '\'' +
                ", mobile='" + mobile + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookAvatar='" + bookAvatar + '\'' +
                '}';
    }
}
