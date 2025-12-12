package com.sliit.library.model;

import com.sliit.library.observer.Observer;
import java.util.ArrayList;
import java.util.List;

public abstract class User implements Observer {
    protected String userID;
    protected String name;
    protected String email;
    protected String contactNumber;
    protected String membershipType;
    protected List<Book> borrowedBooks;
    protected int borrowLimit;
    protected int borrowDays;

    public User(String userID, String name, String email, String contactNumber, String membershipType) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.membershipType = membershipType;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getMembershipType() { return membershipType; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    public abstract double calculateFine(int daysLate);
    public abstract int getBorrowLimit();
    public abstract int getBorrowDays();

    @Override
    public void update(String message) {
        System.out.println("📩 Notification for " + name + ": " + message);
    }

    @Override
    public String toString() {
        return String.format("%s [ID=%s, Type=%s]", name, userID, membershipType);
    }
}
