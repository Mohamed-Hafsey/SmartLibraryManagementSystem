# 📚 Smart Library Management System

A Java-based library management application developed as part of the **Programming III** module at **ESU Colombo**.  
The system automates key library operations such as book management, borrowing, returning, reservations, and report generation while demonstrating effective use of **Object-Oriented Programming (OOP)** concepts and **Design Patterns**.

---

## 🧩 Project Overview

The **Smart Library Management System (SLMS)** is designed to simplify the daily tasks of a university library.  
It allows librarians to manage books and users, and provides students and faculty members with easy access to borrowing, returning, and reserving books.  
The system also includes a notification mechanism for due dates and reserved books, as well as fine calculation for late returns.

This project demonstrates how OOP principles and software design patterns can be applied to develop modular, reusable, and scalable systems.

---

## 🏗️ Features

### 🔹 Book Management
- Add, update, and remove books
- Maintain book availability states (Available, Borrowed, Reserved)
- Track borrowing history

### 🔹 User Management
- Register and manage users (Student, Faculty, Guest)
- Track borrowed books
- Membership-based borrowing limits and fine rates

### 🔹 Borrowing and Returning
- Borrow available books within user limits
- Automatic due date calculation
- Fine calculation for late returns based on user type

### 🔹 Reservations and Notifications
- Reserve books currently borrowed by others
- Automatic notification when reserved book becomes available
- Alerts for due and overdue books

### 🔹 Reports
- Generate reports for librarians:
  - Most borrowed books
  - Active borrowers
  - Overdue books

---

## 🧠 Applied Object-Oriented Concepts

- **Encapsulation** – Used to protect book and user data through private fields and public methods.  
- **Inheritance** – Used for different user types (Student, Faculty, Guest).  
- **Polymorphism** – Allows fine calculation and borrowing rules to vary by user type.  
- **Abstraction** – Simplifies system design through abstract classes and interfaces.

---

## 🎯 Design Patterns Used

| **Pattern** | **Purpose** |
|--------------|-------------|
| **Builder Pattern** | Simplifies creation of complex book objects. |
| **Command Pattern** | Encapsulates user actions like borrow, return, and reserve. |
| **State Pattern** | Manages book availability dynamically. |
| **Strategy Pattern** | Implements different fine calculation methods for each user type. |
| **Observer Pattern** | Sends automatic notifications to users. |
| **Decorator Pattern** | Adds extra book features like “Featured” or “Recommended.” |

---

## 🧪 Testing

Testing was conducted using **Black Box Testing** to verify all major functions.  
All 15 test cases, including book management, borrowing, returning, fine calculation, and notifications, passed successfully.  
The system achieved a 100% success rate across all functional modules.

---

## 🛠️ Technologies Used

- **Programming Language:** Java  
- **IDE:** NetBeans  
- **Paradigm:** Object-Oriented Programming  
- **Design Patterns:** Builder, Command, State, Strategy, Observer, Decorator

---

## 🚀 How to Run

1. Clone or download this repository:  
   ```bash
   git clone https://github.com/<yourusername>/SmartLibraryManagementSystem.git
