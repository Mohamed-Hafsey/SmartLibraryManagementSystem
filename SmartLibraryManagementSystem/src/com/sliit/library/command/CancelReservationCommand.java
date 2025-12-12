package com.sliit.library.command;

import com.sliit.library.model.Book;
import com.sliit.library.model.User;
import com.sliit.library.state.AvailableState;

public class CancelReservationCommand implements Command {
    private final User user;
    private final Book book;

    public CancelReservationCommand(User user, Book book) {
        this.user = user;
        this.book = book;
    }

    @Override
    public void execute() {
        if (book.getStatus().equalsIgnoreCase("Reserved")) {
            book.setState(new AvailableState());
            System.out.println(user.getName() + " canceled reservation for: " + book.getTitle());
        } else {
            System.out.println("Book '" + book.getTitle() + "' is not reserved.");
        }
    }
}
