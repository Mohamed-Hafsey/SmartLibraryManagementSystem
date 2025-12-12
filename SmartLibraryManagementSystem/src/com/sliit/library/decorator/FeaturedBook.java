package com.sliit.library.decorator;

import com.sliit.library.model.Book;

public class FeaturedBook extends BookDecorator {
    public FeaturedBook(Book book) {
        super(book);
    }

    @Override
    public String getFeature() {
        return decoratedBook.getTitle() + " (Featured Book)";
    }
}
