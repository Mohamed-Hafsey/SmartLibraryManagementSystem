package com.sliit.library.command;

import com.sliit.library.model.Book;
import com.sliit.library.model.User;
import com.sliit.library.observer.NotificationManager;

public class ReturnCommand implements Command {
    private final User user;
    private final Book book;
    private final int daysLate;
    private final NotificationManager notificationManager;

    public ReturnCommand(User user, Book book, int daysLate, NotificationManager notificationManager) {
        this.user = user;
        this.book = book;
        this.daysLate = daysLate;
        this.notificationManager = notificationManager;
    }

    @Override
    public void execute() {
        if (user.getBorrowedBooks().contains(book)) {
            user.getBorrowedBooks().remove(book);
            book.returnBook();
            double fine = user.calculateFine(daysLate);

            if (daysLate > 0) {
                System.out.println(user.getName() + " returned late. Fine: LKR " + fine);
            } else {
                System.out.println(user.getName() + " returned on time. No fine.");
            }

            // Notify reserved users that the book is available
            notificationManager.notifyObservers("Book '" + book.getTitle() + "' is now available.");
        } else {
            System.out.println(user.getName() + " did not borrow this book.");
        }
    }
}
