package com.ri.entrty;

import java.util.Date;

public class BorrowVO {
    private String studentId;
    private String account;
    private String borrowBookName;
    private String borrowBookId;
    private String cover;
    private Date borrowTime;
    private String borrowBookAuthor;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBorrowBookName() {
        return borrowBookName;
    }

    public void setBorrowBookName(String borrowBookName) {
        this.borrowBookName = borrowBookName;
    }

    public String getBorrowBookId() {
        return borrowBookId;
    }

    public void setBorrowBookId(String borrowBookId) {
        this.borrowBookId = borrowBookId;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public String getBorrowBookAuthor() {
        return borrowBookAuthor;
    }

    public void setBorrowBookAuthor(String borrowBookAuthor) {
        this.borrowBookAuthor = borrowBookAuthor;
    }

    @Override
    public String toString() {
        return "BorrowVO{" +
                "studentId='" + studentId + '\'' +
                ", account='" + account + '\'' +
                ", borrowBookName='" + borrowBookName + '\'' +
                ", borrowBookId='" + borrowBookId + '\'' +
                ", cover='" + cover + '\'' +
                ", borrowTime=" + borrowTime +
                ", borrowBookAuthor='" + borrowBookAuthor + '\'' +
                '}';
    }
}
