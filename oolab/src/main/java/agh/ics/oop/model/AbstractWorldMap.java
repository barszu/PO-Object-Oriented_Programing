package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements WorldMap{

    protected final Map<Vector2d,Animal> animals = new HashMap<>();
    protected final MapVisualizer mapVis = new MapVisualizer(this);

    @Override
    public boolean place(Animal animal) { //as animal
        if (this.canMoveTo(animal.getPosition())){  //popraw przy zmianie canMoveTo
            this.animals.put(animal.getPosition() , animal);
            return true;
        }
        else { //animal position out of map for example
            return false;
        }
    }

    @Override
    public void move(Animal animal , MoveDirection direction) { //as animal
        if (!this.animals.containsValue(animal)){
            return;
        }
        animals.remove(animal.getPosition());
        animal.move(direction, this);
        this.place((animal));
    }

    @Override
    public boolean isOccupied(Vector2d position) {//as animal
        return this.animals.containsKey(position);
    }

    @Override
    abstract public boolean canMoveTo(Vector2d position);

    @Override
    abstract public WorldElement objectAt(Vector2d position);

    @Override
    abstract public Collection<WorldElement> getElements();

    @Override
    abstract public String toString();
}
