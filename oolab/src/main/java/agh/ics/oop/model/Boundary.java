package agh.ics.oop.model;

import agh.ics.oop.model.models.Vector2d;

public record Boundary(Vector2d lowerLeft , Vector2d upperRight) {
    // for toString map visualization
    //all getters and setters inside
    public int height() {
        return upperRight.getY() - lowerLeft().getY() + 1;
    }

    public int width() {
        return upperRight.getX() - lowerLeft().getX() + 1;
    }
}
