package com.sliit.library.model;

import com.sliit.library.state.*;
import java.util.ArrayList;
import java.util.List;

public class Book {
    private String bookID;
    private String title;
    private String author;
    private String category;
    private String isbn;
    private BookState state;
    private List<String> borrowHistory;

    public Book(BookBuilder builder) {
        this.bookID = builder.bookID;
        this.title = builder.title;
        this.author = builder.author;
        this.category = builder.category;
        this.isbn = builder.isbn;
        this.state = new AvailableState();
        this.borrowHistory = new ArrayList<>();
    }

    public void borrow() { state.borrow(this); }
    public void returnBook() { state.returnBook(this); }
    public void reserve() { state.reserve(this); }

    public String getStatus() { return state.getStatus(); }
    public void setState(BookState state) { this.state = state; }

    public String getBookID() { return bookID; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public String getIsbn() { return isbn; }
    public List<String> getBorrowHistory() { return borrowHistory; }

    @Override
    public String toString() {
        return String.format("%s [ID=%s, Status=%s]", title, bookID, state.getStatus());
    }

    public static class BookBuilder {
        private final String bookID;
        private final String title;
        private String author;
        private String category;
        private String isbn;

        public BookBuilder(String bookID, String title) {
            this.bookID = bookID;
            this.title = title;
        }

        public BookBuilder author(String author) { this.author = author; return this; }
        public BookBuilder category(String category) { this.category = category; return this; }
        public BookBuilder isbn(String isbn) { this.isbn = isbn; return this; }
        public Book build() { return new Book(this); }
    }
}
