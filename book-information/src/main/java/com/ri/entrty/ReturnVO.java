package com.ri.entrty;

import java.util.Date;

public class ReturnVO {
    private Integer id;
    private String studentID;
    private String bookId;
    private Date returnDate;
    private String returnBookName;

    @Override
    public String toString() {
        return "ReturnVO{" +
                "studentID='" + studentID + '\'' +
                ", bookId='" + bookId + '\'' +
                ", returnDate=" + returnDate +
                ", returnBookName='" + returnBookName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getReturnBookName() {
        return returnBookName;
    }

    public void setReturnBookName(String returnBookName) {
        this.returnBookName = returnBookName;
    }
}
