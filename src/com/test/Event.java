package com.test;

/**
 * Created by Cian Bolster on 13/09/2017.
 */
public class Event {
    private int id;
    private double lowestPrice;
    private int xcoord;
    private int ycoord;
    private int distance;

    public Event(int id) {
        this.id = id;
        lowestPrice = Math.random() * 25 + Math.random()* 30;
    }

    public double getLowestPrice() {
        return lowestPrice;
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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getId() {
        return id;
    }
}
