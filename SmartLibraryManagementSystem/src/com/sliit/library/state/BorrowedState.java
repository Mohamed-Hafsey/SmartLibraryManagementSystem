package com.sliit.library.state;

import com.sliit.library.model.Book;

public class BorrowedState implements BookState {

    @Override
    public void borrow(Book book) {
        System.out.println("Book is already borrowed!");
    }

    @Override
    public void returnBook(Book book) {
        book.setState(new AvailableState());
        System.out.println("Book returned successfully!");
    }

    @Override
    public void reserve(Book book) {
        book.setState(new ReservedState());
        System.out.println("Book reserved successfully!");
    }

    @Override
    public String getStatus() {
        return "Borrowed";
    }
}
