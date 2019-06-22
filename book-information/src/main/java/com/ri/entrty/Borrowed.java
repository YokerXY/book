package com.ri.entrty;

public class Borrowed {
    private int borrowed;
    private String bookId;

    @Override
    public String toString() {
        return String.valueOf(borrowed);
    }

    public int getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(int borrowed) {
        this.borrowed = borrowed;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
