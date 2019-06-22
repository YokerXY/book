package com.ri.entrty;

public class Author {
    private String bookId;
    private String author;

    @Override
    public String toString() {
        return author;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
