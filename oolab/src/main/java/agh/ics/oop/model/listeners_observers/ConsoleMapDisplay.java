package agh.ics.oop.model.listeners_observers;

import agh.ics.oop.model.WorldMap;

public class ConsoleMapDisplay implements MapChangeListener {

    private int updateCounter = 0;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {

        System.out.println(message);
        System.out.print(worldMap);
        updateCounter += 1;
    }
}
