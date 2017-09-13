package com.test;

import java.util.ArrayList;

/**
 * Created by Cian Bolster on 13/09/2017.
 */
public class AreaOfEvents {

    private ArrayList<Event> eventList;

    public AreaOfEvents() {
        generateEvents();
    }

    /**
     * Generating the events that populate this general area. It is a random number between 1 and 50
     */

    private void generateEvents(){

        int numberOfEvents = (int) Math.random()* 50;

        for(int i = 1; 1 < numberOfEvents; i++){
            Event e = new Event(i);
            assignCoord(e);
            eventList.add(e);

        }


    }

    private void assignCoord(Event e){
        int xCoord = (int) (Math.random()*20) - 10;
        int yCoord = (int) (Math.random()*20) - 10;

        boolean freeCoord = false;

        while(freeCoord == false){
            for(int i = 0; i < eventList.size(); i++){
                if(xCoord == eventList.get(i).getXcoord() && yCoord == eventList.get(i).getYcoord()){
                    xCoord = (int) (Math.random()*20) - 10;
                    yCoord = (int) (Math.random()*20) - 10;
                }
                else
                    freeCoord = true;
            }
        }

        e.setXcoord(xCoord);
        e.setYcoord(yCoord);

    }
}
