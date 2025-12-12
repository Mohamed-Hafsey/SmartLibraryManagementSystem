    package com.sliit.library.model;

import com.sliit.library.strategy.StudentFineStrategy;
import com.sliit.library.strategy.FineStrategy;

public class Student extends User {
    private final FineStrategy fineStrategy;

    public Student(String id, String name, String email, String contact) {
        super(id, name, email, contact, "Student");
        this.fineStrategy = new StudentFineStrategy();
        this.borrowLimit = 3;
        this.borrowDays = 14;
    }

    @Override
    public double calculateFine(int daysLate) { return fineStrategy.calculateFine(daysLate); }
    @Override
    public int getBorrowLimit() { return borrowLimit; }
    @Override
    public int getBorrowDays() { return borrowDays; }
}
