package agh.ics.oop.model;

import agh.ics.oop.model.models.Vector2d;

public record Boundary(Vector2d lowerLeft , Vector2d topRight) {
    // for toString map visualization
    //all getters and setters inside
}
