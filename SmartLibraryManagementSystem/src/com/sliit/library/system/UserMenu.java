package com.sliit.library.system;

import com.sliit.library.command.*;
import com.sliit.library.model.*;
import com.sliit.library.observer.NotificationManager;
import java.util.*;

public class UserMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void showUserMenu(List<Book> books, List<User> users, NotificationManager notificationManager) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        User currentUser = null;
        for (User u : users) {
            if (u.getName().equalsIgnoreCase(name)) {
                currentUser = u;
                break;
            }
        }

        if (currentUser == null) {
            System.out.println("⚠️ User not found. Returning to main menu.");
            return;
        }

        notificationManager.addObserver(currentUser);

        while (true) {
            System.out.println("\n===== USER MENU =====");
            System.out.println("1. View All Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Reserve Book");
            System.out.println("5. Cancel Reservation");
            System.out.println("6. View Borrowed Books");
            System.out.println("7. Logout");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewBooks(books);
                    break;
                case 2:
                    borrowBook(currentUser, books);
                    break;
                case 3:
                    returnBook(currentUser, books, notificationManager);
                    break;
                case 4:
                    reserveBook(currentUser, books);
                    break;
                case 5:
                    cancelReservation(currentUser, books);
                    break;
                case 6:
                    viewBorrowedBooks(currentUser);
                    break;
                case 7:
                    notificationManager.removeObserver(currentUser);
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    private static void viewBooks(List<Book> books) {
        System.out.println("\n=== AVAILABLE BOOKS ===");
        if (books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    private static void borrowBook(User user, List<Book> books) {
        System.out.print("Enter Book ID to borrow: ");
        String id = scanner.nextLine();
        Book book = findBook(books, id);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        new BorrowCommand(user, book).execute();
    }

    private static void returnBook(User user, List<Book> books, NotificationManager notificationManager) {
        System.out.print("Enter Book ID to return: ");
        String id = scanner.nextLine();
        Book book = findBook(books, id);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        System.out.print("Days late (0 if on time): ");
        int days = scanner.nextInt();
        scanner.nextLine();
        new ReturnCommand(user, book, days, notificationManager).execute();
    }

    private static void reserveBook(User user, List<Book> books) {
        System.out.print("Enter Book ID to reserve: ");
        String id = scanner.nextLine();
        Book book = findBook(books, id);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        new ReserveCommand(user, book).execute();
    }

    private static void cancelReservation(User user, List<Book> books) {
        System.out.print("Enter Book ID to cancel reservation: ");
        String id = scanner.nextLine();
        Book book = findBook(books, id);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        new CancelReservationCommand(user, book).execute();
    }

    private static void viewBorrowedBooks(User user) {
        System.out.println("\n=== BORROWED BOOKS ===");
        if (user.getBorrowedBooks().isEmpty()) {
            System.out.println("No borrowed books.");
            return;
        }
        for (Book b : user.getBorrowedBooks()) {
            System.out.println(b);
        }
    }

    private static Book findBook(List<Book> books, String id) {
        for (Book b : books) {
            if (b.getBookID().equalsIgnoreCase(id)) {
                return b;
            }
        }
        return null;
    }
}
