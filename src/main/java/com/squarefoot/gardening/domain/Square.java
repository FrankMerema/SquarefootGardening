package com.squarefoot.gardening.domain;

public class Square {

    private int raisedBedNumber;
    // west - east
    private int x;
    // north - south
    private int y;

    private Square() {
    }

    public Square(int raisedBedNumber, int x, int y) {
        this.raisedBedNumber = raisedBedNumber;
        this.x = x; // west -> east
        this.y = y; // north -> south
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
