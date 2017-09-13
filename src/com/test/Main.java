package com.test;

import java.util.Scanner;

public class Main {

    static int totalEventsToPrint = 5;

    private static void outputListOfEvents(Event[] e){
        int printNum = e.length;

        if(totalEventsToPrint < printNum){
            printNum = totalEventsToPrint;
        }

        for(int i = 0; i < printNum; i++){
            System.out.printf("Event " + e[i].getId() + " - $%.2f, Distance - " + e[i].getDistance()+ " "+e[i].getXcoord()+" "+e[i].getYcoord()+"\n", e[i].getLowestPrice() );
        }
    }

    public static void main(String[] args) {

        AreaOfEvents a = new AreaOfEvents();
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter coordinates in the range -10,-10 to 10,10:");

        /**
         * Going to assume that the user follows the instruction on entering data.
         * However a regex checker would be used to check if the correct input was given.
         */

        String userCoords = sc.nextLine();

        String [] userCoordsValue = userCoords.split(",");

        Event[] eventList = a.getSortedEventsList(Integer.parseInt(userCoordsValue[0]), Integer.parseInt(userCoordsValue[1]));

        outputListOfEvents(eventList);

    }


}
