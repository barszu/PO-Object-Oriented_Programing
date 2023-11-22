package agh.ics.oop.model;

import agh.ics.oop.World;
import agh.ics.oop.model.util.MapVisualizer;
import agh.ics.oop.my_package.Rectangle;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap{
    private final Rectangle rectangleBox;
//    private final Map<Vector2d,Animal> animals;
    private final int width;
    private final int height;


    public RectangularMap(int width, int height) {
        if (width<0 || height<0) {
            throw new IllegalArgumentException("invalid width or height in RectangularMap");
        }
        this.width = width;
        this.height = height;
        this.rectangleBox = new Rectangle(new Vector2d(0,0),new Vector2d(width,height));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (this.rectangleBox.contains(position)) && (!this.isOccupied(position));
    }

    @Override
    public Animal objectAt(Vector2d position) {
        if (!isOccupied(position)){
            return null;
        }
        return super.animals.get(position); //TODO
    }

    @Override
    public String toString() {
        return mapVis.draw(new Vector2d(0 , 0) , new Vector2d(this.width,this.height) );
    }
}
