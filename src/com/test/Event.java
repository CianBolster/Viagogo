package com.test;

/**
 * Created by Cian Bolster on 13/09/2017.
 */
public class Event {
    private int id;
    private int lowestPrice;
    private int xcoord;
    private int ycoord;

    public Event(int id) {
    }

    public int getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(int lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public int getXcoord() {
        return xcoord;
    }

    public void setXcoord(int xcoord) {
        this.xcoord = xcoord;
    }

    public int getYcoord() {
        return ycoord;
    }

    public void setYcoord(int ycoord) {
        this.ycoord = ycoord;
    }
}
