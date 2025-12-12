package com.sliit.library.strategy;

public class GuestFineStrategy implements FineStrategy {
    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 100.0;   // LKR 100 per day
    }
}
