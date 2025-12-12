package com.sliit.library.model;

import com.sliit.library.strategy.GuestFineStrategy;
import com.sliit.library.strategy.FineStrategy;

public class Guest extends User {
    private final FineStrategy fineStrategy;

    public Guest(String id, String name, String email, String contact) {
        super(id, name, email, contact, "Guest");
        this.fineStrategy = new GuestFineStrategy();
        this.borrowLimit = 2;
        this.borrowDays = 7;
    }

    @Override
    public double calculateFine(int daysLate) { return fineStrategy.calculateFine(daysLate); }
    @Override
    public int getBorrowLimit() { return borrowLimit; }
    @Override
    public int getBorrowDays() { return borrowDays; }
}
