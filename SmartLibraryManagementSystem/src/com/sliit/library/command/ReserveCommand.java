package com.sliit.library.command;

import com.sliit.library.model.Book;
import com.sliit.library.model.User;

public class ReserveCommand implements Command {
    private final User user;
    private final Book book;

    public ReserveCommand(User user, Book book) {
        this.user = user;
        this.book = book;
    }

    @Override
    public void execute() {
        if (book.getStatus().equalsIgnoreCase("Borrowed")) {
            book.reserve();
            System.out.println(user.getName() + " reserved: " + book.getTitle());
        } else {
            System.out.println("Book '" + book.getTitle() + "' is not borrowed; reservation not needed.");
        }
    }
}
