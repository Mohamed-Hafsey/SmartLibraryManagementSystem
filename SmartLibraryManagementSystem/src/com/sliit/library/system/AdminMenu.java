package com.sliit.library.system;

import com.sliit.library.model.*;
import com.sliit.library.report.ReportManager;
import com.sliit.library.observer.NotificationManager;
import java.util.*;

public class AdminMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void showAdminMenu(List<Book> books, List<User> users, NotificationManager notificationManager) {
        while (true) {
            System.out.println("\n===== ADMIN MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. View All Books");
            System.out.println("4. View All Users");
            System.out.println("5. Generate Reports");
            System.out.println("6. Back to Main Menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook(books);
                    break;
                case 2:
                    removeBook(books);
                    break;
                case 3:
                    viewBooks(books);
                    break;
                case 4:
                    viewUsers(users);
                    break;
                case 5:
                    generateReports(books, users);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    private static void addBook(List<Book> books) {
        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Category: ");
        String category = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        Book book = new Book.BookBuilder(id, title)
                .author(author)
                .category(category)
                .isbn(isbn)
                .build();

        books.add(book);
        System.out.println("Book added successfully!");
    }

    private static void removeBook(List<Book> books) {
        System.out.print("Enter Book ID to remove: ");
        String id = scanner.nextLine();
        boolean removed = books.removeIf(b -> b.getBookID().equalsIgnoreCase(id));
        if (removed)
            System.out.println("Book removed successfully.");
        else
            System.out.println("Book not found.");
    }

    private static void viewBooks(List<Book> books) {
        System.out.println("\n=== ALL BOOKS ===");
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private static void viewUsers(List<User> users) {
        System.out.println("\n=== ALL USERS ===");
        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }
        for (User user : users) {
            System.out.println(user);
        }
    }

    private static void generateReports(List<Book> books, List<User> users) {
        ReportManager.generateMostBorrowedBooksReport(books);
        ReportManager.generateActiveBorrowersReport(users);
        ReportManager.generateOverdueBooksReport(users);
    }
}
