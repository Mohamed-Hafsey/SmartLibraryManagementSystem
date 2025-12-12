package com.sliit.library.decorator;

import com.sliit.library.model.Book;

public class RecommendedBook extends BookDecorator {
    public RecommendedBook(Book book) {
        super(book);
    }

    @Override
    public String getFeature() {
        return decoratedBook.getTitle() + " (👍 Recommended)";
    }
}
