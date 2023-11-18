package agh.ics.oop.model;

public class GrassField implements WorldMap<Animal,Vector2d>{

    int grassNo;


    public GrassField(int grassNo) {
        if (grassNo < 0){
            throw new IllegalArgumentException("negative grassNo in GrassField");
        }
        this.grassNo = grassNo;
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return null;
    }
}
