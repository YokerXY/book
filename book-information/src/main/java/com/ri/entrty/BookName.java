package com.ri.entrty;

public class BookName {
    private String bookId;
    private String bookName;

    @Override
    public String toString() {
        return bookName;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
