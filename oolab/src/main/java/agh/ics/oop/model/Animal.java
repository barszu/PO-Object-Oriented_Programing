package agh.ics.oop.model;

public class Animal {
    private MapDirection direction ;
    private Vector2d position;

    public Animal(){
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }

    public Animal(Vector2d fixedPosition){
        this.direction = MapDirection.NORTH;
        this.position = fixedPosition;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "d=" + direction.toString() +
                ", pos=" + position.toString() +
                '}';
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
}
