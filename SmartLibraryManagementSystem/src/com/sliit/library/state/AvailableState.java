package com.sliit.library.state;

import com.sliit.library.model.Book;

public class AvailableState implements BookState {

    @Override
    public void borrow(Book book) {
        book.setState(new BorrowedState());
        System.out.println("Book borrowed successfully!");
    }

    @Override
    public void returnBook(Book book) {
        System.out.println("Book is already available.");
    }

    @Override
    public void reserve(Book book) {
        book.setState(new ReservedState());
        System.out.println("Book reserved successfully!");
    }

    @Override
    public String getStatus() {
        return "Available";
    }
}
