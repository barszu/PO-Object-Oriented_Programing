package agh.ics.oop.model;
import agh.ics.oop.World; //for WORLD_BORDER

public class Animal {


    private MapDirection direction ;
    private Vector2d position;

    // for printing use "Zwierzę i : (x ,y)"
    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getDirection() {
        return direction;
    }

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

    public void move(MoveDirection direction){
        Vector2d newPosition = null;
        switch (direction){
            //changing direction by rotation
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            //changing position, go forward/backward with no rotation
            case FORWARD -> newPosition = this.position.add(this.direction.toUnitVector());
            case BACKWARD -> newPosition = this.position.subtract(this.direction.toUnitVector());
        }
        //position value has changed, else (-> rotation) do nothing
        if (newPosition!=null && World.WORLD_BORDER.contains(newPosition)){
            this.position = newPosition;
        }
    }
}
