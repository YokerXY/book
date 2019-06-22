package com.ri.entrty;

public class InsertReturn {
    private Integer id;
    private String studentID;
    private String bookId;
    private String  returnDate;

    @Override
    public String toString() {
        return "InsertReturn{" +
                "id=" + id +
                ", studentID='" + studentID + '\'' +
                ", bookId='" + bookId + '\'' +
                ", returnDate='" + returnDate + '\'' +
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

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
