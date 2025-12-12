package com.sliit.library.state;

import com.sliit.library.model.Book;

public class ReservedState implements BookState {

    @Override
    public void borrow(Book book) {
        System.out.println("Book is reserved and cannot be borrowed right now.");
    }

    @Override
    public void returnBook(Book book) {
        book.setState(new AvailableState());
        System.out.println("Book returned successfully and is now available.");
    }

    @Override
    public void reserve(Book book) {
        System.out.println("Book is already reserved!");
    }

    @Override
    public String getStatus() {
        return "Reserved";
    }
}
