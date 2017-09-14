package com.test;

import java.util.ArrayList;

/**
 * Created by Cian Bolster on 13/09/2017.
 * This is the object that holds the information for the coordinates that the events are taking place along with
 * the generation of the events itself.
 *
 * It has predetermined world sizes however these can be easily changed to fit a larger area.
 *
 * One thing of note is that the 2d array is used to make sure that there are always unique coordinates.
 * Getting rid of this array would allow the program ro run without needing to assign unique coordinates to the
 * events.
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
     * Generating the events that populate this particular instance of AreaOfEvents.
     * It is a random number between 1 and 20 for the purpose of demonstration.
     * Also handles the assigning of coordinates.
     */

    private void generateEvents(){
        int numberOfEvents = (int) ((Math.random()* 20) + 1);

        eventTotal = numberOfEvents;

        for(int i = 0; i < numberOfEvents; i++){
            Event e = new Event(i+1);
            assignCoord(e);
            eventsArray[e.getXcoord() + worldSizeX/2][e.getYcoord() + worldSizeY/2] = e;
            // Code to check if events were getting their coordinates assigned
            // System.out.println("Assigned Coord for event " + e.getId());
        }

        // Code to say when the event generation had finished
        // System.out.println("Fin generating events");

    }

    /**
     * This method ensures that the Event that is being passed in is getting a unique coordinate
     *
     */

    private void assignCoord(Event e){
        int xCoord = (int) (Math.random()*20);
        int yCoord = (int) (Math.random()*20);

        boolean freeCoord = false;

        /* This is a slow point in the program if there are a large number of events and the random keeps giving
           values that have already been assigned.

        */

        while(!freeCoord){
          if(eventsArray[xCoord][yCoord] != null){
              xCoord = (int) (Math.random()*20);
              yCoord = (int) (Math.random()*20);
          } else
              freeCoord = true;
        }

        e.setXcoord(xCoord - 10);
        e.setYcoord(yCoord - 10);



    }

    /**
     * Creation an array which is then sorted based on distance from lowest to highest and then based back that
     * array.
     * Bubble sort was used for sorting.
     */

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

        //Bubble sort
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
