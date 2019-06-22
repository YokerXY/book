package com.ri.entrty;

public class InsertBorrow {
    private String studentId;
    private Integer id;
    private String borrowBookId;
    private String  borrowTime;

    @Override
    public String toString() {
        return "InsertBorrow{" +
                "studentId='" + studentId + '\'' +
                ", id=" + id +
                ", borrowBookId='" + borrowBookId + '\'' +
                ", borrowTime='" + borrowTime + '\'' +
                '}';
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBorrowBookId() {
        return borrowBookId;
    }

    public void setBorrowBookId(String borrowBookId) {
        this.borrowBookId = borrowBookId;
    }

    public String getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }
}
