package com.squarefoot.gardening.domain;


public class Week {

    private int weekNumber;

    private Week() {
    }

    public Week(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    @Override
    public String toString() {
        return "" + weekNumber;
    }

    // ********************************
    // Getters and setters
    // ********************************

    public int getWeekNumber() {
        return weekNumber;
    }
}
