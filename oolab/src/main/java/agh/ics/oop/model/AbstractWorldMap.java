package agh.ics.oop.model;

import agh.ics.oop.model.exceptions.PositionAlreadyOccupiedException;
import agh.ics.oop.model.listeners_observers.MapChangeListener;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

abstract class AbstractWorldMap implements WorldMap{

    protected final Map<Vector2d,Animal> animals = new HashMap<>();
    protected final MapVisualizer mapVis = new MapVisualizer(this);
    private final List<MapChangeListener> observersList = new ArrayList<>();

    @Override
    public void place(Animal animal) throws PositionAlreadyOccupiedException { //as animal
        if (canMoveTo(animal.getPosition())){  //popraw przy zmianie canMoveTo
            this.animals.put(animal.getPosition() , animal);
            mapChanged(String.format("Animal: '%s' has been placed on '%s'",animal,animal.getPosition()));
        }
        else { //animal position out of map for example
            throw new PositionAlreadyOccupiedException(animal.getPosition());
        }
    }

    @Override
    public void move(Animal animal , MoveDirection direction) { //as animal
        if (!animals.containsKey(animal.getPosition())){
            return;
        }
        animals.remove(animal.getPosition());
        try {
            Vector2d oldAnimalPos = animal.getPosition();
            animal.move(direction, this);
            animals.put(animal.getPosition() , animal);
            mapChanged(String.format("Animal: '%s' has been moved from '%s' to '%s'",animal,oldAnimalPos,animal.getPosition()));
//            //notify observers when Animal has changed pos not orientation
//            if (!oldAnimalPos.equals(animal.getPosition())){
//                mapChanged(String.format("Animal: '%s' has been moved from '%s' to '%s'",animal,oldAnimalPos,animal.getPosition()));
//            }


        } catch (PositionAlreadyOccupiedException e){
            // nothing to do!
            animals.put(animal.getPosition() , animal);
            System.out.println("WARNING (Animal move was skipped and position not modified): When moving Animal: " + e.getMessage());
        }

//        animals.put(animal.getPosition() , animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {//as animal
        return animals.containsKey(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        return !animals.containsKey(position); //colisions with other animals ON
    }

    @Override
    public WorldElement objectAt(Vector2d position){
        if (animals.containsKey(position)){ //by animal
            return animals.get(position);
        }
        else return null;
    }

    @Override
    public Collection<WorldElement> getElements(){
        return new ArrayList<>(animals.values());
    }


    // observers section

    @Override
    public void addObserver(MapChangeListener observer) {observersList.add(observer);}
    @Override
    public void removeObserver(MapChangeListener observer) {observersList.remove(observer);}

    protected void mapChanged(String description) {
        //notify all observers
        for (MapChangeListener observer : observersList) {
            observer.mapChanged(this , description);
        }

    }


}
