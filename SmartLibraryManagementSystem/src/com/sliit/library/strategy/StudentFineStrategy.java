package com.sliit.library.strategy;

public class StudentFineStrategy implements FineStrategy {
    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 50.0;   // LKR 50 per day
    }
}
