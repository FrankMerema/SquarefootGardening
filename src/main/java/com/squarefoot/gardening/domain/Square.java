package com.squarefoot.gardening.domain;

public class Square {

    private int raisedBedNumber;
    // west - oost
    private int x;
    // noord - zuid
    private int y;

    private Square() {
    }

    public Square(int raisedBedNumber, int x, int y) {
        this.raisedBedNumber = raisedBedNumber;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "" + raisedBedNumber + "(" + x + "," + y + ")";
    }

    // ********************************
    // Getters and setters
    // ********************************

    public int getRaisedBedNumber() {
        return raisedBedNumber;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
