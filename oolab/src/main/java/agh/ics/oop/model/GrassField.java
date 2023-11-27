package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;
import agh.ics.oop.my_package.RandomPositionGenerator;

import java.util.*;

public class GrassField extends AbstractWorldMap{

    private final Map<Vector2d,Grass> grasses = new HashMap<>();


    public GrassField(int grassNo) { //puts grass
        if (grassNo < 0){
            throw new IllegalArgumentException("negative grassNo in GrassField");
        }

        int xyLastCord = (int) Math.round(Math.sqrt(10*grassNo));
        Vector2d topLeft = new Vector2d(0,0);
        Vector2d bottomRight = new Vector2d(xyLastCord , xyLastCord);

        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(bottomRight,grassNo);
        for(Vector2d grassPosition : randomPositionGenerator) {
            grasses.put(grassPosition, new Grass(grassPosition));
        }

    }

    @Override
    public WorldElement objectAt(Vector2d position) { //as animal or grass
        WorldElement animal = super.objectAt(position);
        if (animal != null){
            return animal;
        }
        if (this.grasses.containsKey(position)){ //otherwise maybe grass
            return this.grasses.get(position);
        }
        return null; //nothing
    }

    @Override
    public boolean isOccupied(Vector2d position) {//as animal or grass
        return (super.animals.containsKey(position)) || (this.grasses.containsKey(position)) ;
    }

    @Override
    public Collection<WorldElement> getElements() {
        Collection<WorldElement> elements = new ArrayList<>();
        elements.addAll(grasses.values());
        elements.addAll(animals.values());
        return elements;
    }

}
