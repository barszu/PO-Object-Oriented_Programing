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
    public boolean canMoveTo(Vector2d position) { //as animal
        return !super.animals.containsKey(position); //colisions with other animals ON
    }

    @Override
    public WorldElement objectAt(Vector2d position) { //as animal or grass
        if (super.animals.containsKey(position)){ //by animal
            return super.animals.get(position);
        }
        if (this.grasses.containsKey(position)){ //otherwise grass
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
        return Collections.unmodifiableCollection(elements);
    }

    public String toString() {
        if (animals.keySet().isEmpty()){
            return mapVis.draw(new Vector2d(0,0) , new Vector2d(1,1));
        }
        //for animals
        List<Vector2d> positionsList = new ArrayList<>(animals.keySet());
        Vector2d MOSTLowerLeftPoint = positionsList.get(0); // "min"
        Vector2d MOSTUpperRightPoint = positionsList.get(0); // "max"
        for (Vector2d current : positionsList) {
            MOSTUpperRightPoint = current.upperRight(MOSTUpperRightPoint) ; // for "max"
            MOSTLowerLeftPoint = current.lowerLeft(MOSTLowerLeftPoint) ; // for "min"
        }

        return mapVis.draw(MOSTLowerLeftPoint , MOSTUpperRightPoint );
    }

}
