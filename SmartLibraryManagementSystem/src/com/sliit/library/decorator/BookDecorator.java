package com.sliit.library.decorator;

import com.sliit.library.model.Book;

public abstract class BookDecorator extends Book {
    protected Book decoratedBook;

    public BookDecorator(Book book) {
        super(new Book.BookBuilder(book.getBookID(), book.getTitle())
                .author(book.getAuthor())
                .category(book.getCategory())
                .isbn(book.getIsbn()));
        this.decoratedBook = book;
    }

    public abstract String getFeature();
}
