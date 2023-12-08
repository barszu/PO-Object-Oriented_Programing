package agh.ics.oop.model.observers;

import agh.ics.oop.model.WorldMap;

public class ConsoleMapDisplay implements MapChangeListener {

    private int updateCounter = 0;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {

        System.out.println(message);
        System.out.println("UUID: " + worldMap.getId());

        //only for better visualization
        String mapTypeName = worldMap.getClass().getSimpleName();
        System.out.println("Map Type: " + mapTypeName);

        System.out.print(worldMap);
        updateCounter += 1;
    }
}
