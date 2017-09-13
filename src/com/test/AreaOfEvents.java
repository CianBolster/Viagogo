package com.test;

import java.util.ArrayList;

/**
 * Created by Cian Bolster on 13/09/2017.
 */
public class AreaOfEvents {

    private int worldSizeX = 20;
    private int worldSizeY = 20;
    private Event eventsArray[][] = new Event[worldSizeX][worldSizeY];
    private int eventTotal;

    public AreaOfEvents() {
        generateEvents();
    }

    /**
     * Generating the events that populate this general area. It is a random number between 1 and 20
     */

    private void generateEvents(){

        int numberOfEvents = (int) ((Math.random()* 20) + 1);

        eventTotal = numberOfEvents;

        for(int i = 0; i < numberOfEvents; i++){
            Event e = new Event(i+1);
            assignCoord(e);
            eventsArray[e.getXcoord()][e.getYcoord()] = e;
            System.out.println("Assigned Coord for event " + e.getId());
        }

        System.out.println("Fin generating events");

    }

    private void assignCoord(Event e){
        int xCoord = (int) (Math.random()*20);
        int yCoord = (int) (Math.random()*20);

        boolean freeCoord = false;

        while(!freeCoord){
          if(eventsArray[xCoord][yCoord] != null){
              xCoord = (int) (Math.random()*20);
              yCoord = (int) (Math.random()*20);
          } else
              freeCoord = true;
        }

        e.setXcoord(xCoord);
        e.setYcoord(yCoord);



    }

    //Area to focus on for now

    public Event[] getSortedEventsList(int currentLocX, int currentLocY){
        Event[] nearEvents = new Event[eventTotal];
        int count = 0;
        Event temp;

        for (int i = 0; i < worldSizeX; i++){
            for (int j = 0; j < worldSizeY; j++){
                if(eventsArray[i][j] != null){
                    eventsArray[i][j].setDistance(setDistance(eventsArray[i][j].getYcoord(), eventsArray[i][j].getYcoord(), currentLocX,
                            currentLocY));
                    nearEvents[count] = eventsArray[i][j];
                    count++;
                    }
            }
        }

        for(int i = 0; i < eventTotal; i++){
            for(int j = 1; j < eventTotal - i; j++){
                if (nearEvents[j - 1].getDistance() > nearEvents[j].getDistance()){
                    temp = nearEvents[j - 1];
                    nearEvents[j -1] = nearEvents[j];
                    nearEvents[j] = temp;
                }
            }
        }

        return nearEvents;
    }

    private int setDistance(int eventX, int eventY, int currentX, int currentY){
        int d;

        d = (Math.abs(eventX - currentX) + Math.abs(eventY - currentY));

        return d;
    }
}
