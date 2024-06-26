package agh.ics.oop.model.exceptions;

import agh.ics.oop.model.models.Vector2d;

public class PositionAlreadyOccupiedException extends Exception{

    public PositionAlreadyOccupiedException(Vector2d position) {
        super("Position " + position + " is already occupied.");
    }
}
