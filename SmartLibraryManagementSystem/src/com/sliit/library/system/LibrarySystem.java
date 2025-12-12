package com.sliit.library.system;

import com.sliit.library.model.*;
import com.sliit.library.observer.NotificationManager;
import com.sliit.library.report.ReportManager;
import java.util.*;

public class LibrarySystem {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Book> books = new ArrayList<>();
    private static final List<User> users = new ArrayList<>();
    private static final NotificationManager notificationManager = new NotificationManager();

    public static void main(String[] args) {
        System.out.println("===== SMART LIBRARY MANAGEMENT SYSTEM =====");

        // Load demo data
        initializeDemoData();

        while (true) {
            System.out.println("\nMAIN MENU");
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("3. Register New User");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    AdminMenu.showAdminMenu(books, users, notificationManager);
                    break;
                case 2:
                    UserMenu.showUserMenu(books, users, notificationManager);
                    break;
                case 3:
                    registerNewUser();
                    break;
                case 4:
                    System.out.println("Thank you for using the Smart Library System!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }

    private static void initializeDemoData() {
        // Sample books
        books.add(new Book.BookBuilder("B001", "Design Patterns")
                .author("Erich Gamma")
                .category("Software Engineering")
                .isbn("978-0201633610")
                .build());

        books.add(new Book.BookBuilder("B002", "Clean Code")
                .author("Robert C. Martin")
                .category("Programming")
                .isbn("978-0132350884")
                .build());

        users.add(new Student("U001", "Nimal", "nimal@gmail.com", "0711234567"));
        users.add(new Faculty("U002", "Dr. Perera", "perera@gmail.com", "0719876543"));
        users.add(new Guest("U003", "Kamal", "kamal@gmail.com", "0715555555"));

        System.out.println("Demo data loaded successfully.");
    }

    private static void registerNewUser() {
        System.out.println("\n=== USER REGISTRATION ===");

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();

        System.out.println("Select Membership Type:");
        System.out.println("1. Student");
        System.out.println("2. Faculty");
        System.out.println("3. Guest");
        System.out.print("Enter choice: ");
        int type = scanner.nextInt();
        scanner.nextLine();

        String id = "U" + String.format("%03d", users.size() + 1);
        User newUser = null;

        switch (type) {
            case 1:
                newUser = new Student(id, name, email, contact);
                break;
            case 2:
                newUser = new Faculty(id, name, email, contact);
                break;
            case 3:
                newUser = new Guest(id, name, email, contact);
                break;
            default:
                System.out.println("Invalid type. Registration canceled.");
                return;
        }

        users.add(newUser);
        System.out.println("User registered successfully");
        System.out.println("Assigned User ID: " + id);
    }
}
