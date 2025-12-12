package com.sliit.library.decorator;

import com.sliit.library.model.Book;

public class SpecialEditionBook extends BookDecorator {
    public SpecialEditionBook(Book book) {
        super(book);
    }

    @Override
    public String getFeature() {
        return decoratedBook.getTitle() + " (💎 Special Edition)";
    }
}
