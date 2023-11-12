package agh.ics.oop.model;

import agh.ics.oop.World;
import agh.ics.oop.model.util.MapVisualizer;
import agh.ics.oop.my_package.Rectangle;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap{

    private final Rectangle rectangleBox;
    private Map<Vector2d,Animal> animals;
    private final int width;
    private final int height;


    public RectangularMap(int width, int height) {
        if (width<0 || height<0) {
            throw new IllegalArgumentException("invalid width or height in RectangularMap");
        }
        this.animals = new HashMap<>();
        this.width = width;
        this.height = height;
        this.rectangleBox = new Rectangle(new Vector2d(0,0),new Vector2d(width,height));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        //czy mozna tu stanac?
        return this.rectangleBox.contains(position);
    }

    @Override
    public boolean place(Animal animal) {

        if (this.canMoveTo(animal.getPosition())){  //popraw przy zmianie canMoveTo
            this.animals.put(animal.getPosition() , animal);
            return true;
        }
        else { //animal position out of map
            return false;
        }

    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        if (!this.animals.containsValue(animal)){
            return;
        }
        animals.remove(animal.getPosition());
        animal.move(direction, this);
        this.place((animal));
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.animals.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        if (!isOccupied(position)){
            return null;
        }
        return this.animals.get(position);
    }

    @Override
    public String toString() {
        MapVisualizer mapVis = new MapVisualizer(this);
//        return mapVis.draw(new Vector2d(0,this.height) , new Vector2d(this.width , 0));
        return mapVis.draw(new Vector2d(0 , 0) , new Vector2d(this.width,this.height) );
    }
}
