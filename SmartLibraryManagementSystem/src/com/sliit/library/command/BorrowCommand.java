package com.sliit.library.command;

import com.sliit.library.model.Book;
import com.sliit.library.model.User;

public class BorrowCommand implements Command {
    private final User user;
    private final Book book;

    public BorrowCommand(User user, Book book) {
        this.user = user;
        this.book = book;
    }

    @Override
    public void execute() {
        if (user.getBorrowedBooks().size() >= user.getBorrowLimit()) {
            System.out.println(user.getName() + " has reached the borrowing limit.");
            return;
        }

        String status = book.getStatus();
        if (status.equalsIgnoreCase("Available")) {
            book.borrow();
            user.getBorrowedBooks().add(book);
            book.getBorrowHistory().add(user.getName());
            System.out.println(user.getName() + " borrowed: " + book.getTitle());
        } else {
            System.out.println("Book '" + book.getTitle() + "' is not available right now.");
        }
    }
}
