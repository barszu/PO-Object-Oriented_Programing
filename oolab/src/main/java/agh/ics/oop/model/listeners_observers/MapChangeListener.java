package agh.ics.oop.model.listeners_observers;

import agh.ics.oop.model.WorldMap;

public interface MapChangeListener {
    void mapChanged(WorldMap worldMap, String message);
}
