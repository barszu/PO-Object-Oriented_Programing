package agh.ics.oop.model.models;

public interface WorldElement {
    Vector2d getPosition();

    boolean isAt(Vector2d position);
    String toString();
}
