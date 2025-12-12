package com.sliit.library.strategy;

public class FacultyFineStrategy implements FineStrategy {
    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 20.0;   // LKR 20 per day
    }
}
