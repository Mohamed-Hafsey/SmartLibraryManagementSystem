package com.sliit.library.model;

import com.sliit.library.strategy.FacultyFineStrategy;
import com.sliit.library.strategy.FineStrategy;

public class Faculty extends User {
    private final FineStrategy fineStrategy;

    public Faculty(String id, String name, String email, String contact) {
        super(id, name, email, contact, "Faculty");
        this.fineStrategy = new FacultyFineStrategy();
        this.borrowLimit = 5;
        this.borrowDays = 30;
    }

    @Override
    public double calculateFine(int daysLate) { return fineStrategy.calculateFine(daysLate); }
    @Override
    public int getBorrowLimit() { return borrowLimit; }
    @Override
    public int getBorrowDays() { return borrowDays; }
}
