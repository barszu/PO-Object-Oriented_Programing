package agh.ics.oop.model;

import agh.ics.oop.World;
import agh.ics.oop.model.util.MapVisualizer;
import agh.ics.oop.my_package.Rectangle;

import java.util.*;

public class RectangularMap extends AbstractWorldMap{
    private final Rectangle rectangleBox;
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
        return (this.rectangleBox.contains(position)) && (super.canMoveTo(position));
    }

    @Override
    public Collection<WorldElement> getElements() {
        return new ArrayList<>(animals.values());
    }

    @Override
    public String toString() {
        return mapVis.draw(new Vector2d(0 , 0) , new Vector2d(this.width,this.height) );
    }
}
