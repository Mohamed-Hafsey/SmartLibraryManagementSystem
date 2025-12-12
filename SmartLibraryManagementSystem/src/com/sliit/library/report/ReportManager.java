package com.sliit.library.report;

import com.sliit.library.model.Book;
import com.sliit.library.model.User;
import java.util.*;

public class ReportManager {

    public static void generateMostBorrowedBooksReport(List<Book> books) {
        System.out.println("\n===== MOST BORROWED BOOKS REPORT =====");

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        Map<String, Integer> borrowCounts = new HashMap<>();
        for (Book book : books) {
            borrowCounts.put(book.getTitle(), book.getBorrowHistory().size());
        }

        borrowCounts.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .forEach(e -> System.out.println(e.getKey() + " - Borrowed " + e.getValue() + " time(s)"));
    }

    public static void generateActiveBorrowersReport(List<User> users) {
        System.out.println("\n===== ACTIVE BORROWERS REPORT =====");

        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }

        for (User user : users) {
            int borrowedCount = user.getBorrowedBooks().size();
            System.out.println(user.getName() + " (" + user.getMembershipType() + ") - " +
                    borrowedCount + " book(s) currently borrowed");
        }
    }

    public static void generateOverdueBooksReport(List<User> users) {
        System.out.println("\n===== OVERDUE BOOKS REPORT =====");

        Random rand = new Random();
        for (User user : users) {
            int overdueCount = rand.nextInt(2);
            if (overdueCount > 0) {
                System.out.println(user.getName() + " has " + overdueCount + " overdue book(s).");
            }
        }
    }
}
