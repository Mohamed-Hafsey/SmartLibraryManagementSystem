package com.sliit.library.state;

import com.sliit.library.model.Book;

public interface BookState {
    void borrow(Book book);
    void returnBook(Book book);
    void reserve(Book book);
    String getStatus();
}
