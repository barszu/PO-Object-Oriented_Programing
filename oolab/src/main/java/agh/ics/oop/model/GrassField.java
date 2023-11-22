package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;
import agh.ics.oop.my_package.RandomPositionGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrassField implements WorldMap<WorldElement,Vector2d>{

    private final Map<Vector2d,Grass> grasses = new HashMap<>();
    private final Map<Vector2d,Animal> animals = new HashMap<>();


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

//    TODO umożliwia nieograniczone poruszanie się zwierzęcia po mapie, pod warunkiem, że nie wchodzi na inne zwierzę - rozmiar mapy ma być "nieskończony" (czyli ograniczony tylko możliwościami int-a)

    @Override
    public boolean canMoveTo(Vector2d position) { //as animal
        return !this.isOccupied(position);
    }

    @Override
    public boolean place(WorldElement animal) { //as animal
        //TODO
        return false;
    }

    @Override
    public void move(WorldElement animal, MoveDirection direction) { //as animal
        //TODO
    }

    @Override
    public boolean isOccupied(Vector2d position) { //as animal
        return this.animals.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position) { //as animal
        if (!isOccupied(position)){
            return null;
        }
        return this.animals.get(position);
    }

    public String toString() {
        MapVisualizer mapVis = new MapVisualizer(this);
        if (animals.keySet().size() == 0){ //print of empty map
            return mapVis.draw(new Vector2d(0,0) , new Vector2d(1,1));
        }

        List<Vector2d> positionsList = new ArrayList<>(animals.keySet());
        Vector2d MOSTtopLeftPoint = positionsList.get(0); // "min"
        Vector2d MOSTbottomRightPoint = positionsList.get(0); // "max"
        for (Vector2d current : positionsList) {
            // for "max"
            if (current.isDownRightRespectTo(MOSTbottomRightPoint)) {
                MOSTbottomRightPoint = current;
            }
            // for "min"
            else if (current.isUpLeftRespectTo(MOSTtopLeftPoint)) {
                MOSTtopLeftPoint = current;
            }
        }
        return mapVis.draw(MOSTtopLeftPoint , MOSTbottomRightPoint );
    }

}
