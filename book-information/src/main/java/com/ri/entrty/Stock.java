package com.ri.entrty;

public class Stock {
    private String bookId;
    private int stock;

    @Override
    public String toString() {
        return String.valueOf(stock);
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
