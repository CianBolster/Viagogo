package com.test;

public class Main {

    public static void main(String[] args) {

        AreaOfEvents a = new AreaOfEvents();

        Event[] eventList = a.getSortedEventsList(4, -6);

        for(int i = 0; i < eventList.length; i++){
            System.out.println("Distance = " + eventList[i].getDistance());
        }

    }
}
