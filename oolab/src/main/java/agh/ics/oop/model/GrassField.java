package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;
import agh.ics.oop.my_package.RandomPositionGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrassField extends AbstractWorldMap{

    private final Map<Vector2d,Grass> grasses = new HashMap<>();


    public GrassField(int grassNo) { //puts grass
//        super();
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
    public boolean canMoveTo(Vector2d position) { //as animal , changed
        return !this.isOccupied(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) { //as animal or grass

        if (isOccupied(position)){ //by animal
            return super.animals.get(position); //TODO
        }
        if (this.grasses.containsKey(position)){
            return this.grasses.get(position);
        }
        return null;

    }

    public String toString() {
        if (animals.keySet().isEmpty()){ //print of empty map //TODO
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
