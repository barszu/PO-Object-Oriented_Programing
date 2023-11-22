package agh.ics.oop.notUsed;

import java.util.HashMap;
import java.util.Map;

public class TextMap {
//        implements WorldMap{

    private final int mapSize;
    private final Map<Integer, StringObject> dataSet;

    public TextMap(int mapSize){
        if (mapSize<0) {
            throw new IllegalArgumentException("negative mapSize in TextMap");
        }
        this.mapSize = mapSize;
        this.dataSet = new HashMap<>();

    }

//    @Override
    public boolean canMoveTo(Integer position) { //in boundaries?
        return (position >= 0)&&(position<mapSize);
    }

//    @Override
//    public boolean place(StringObject element) {
//        if (dataSet.size() < mapSize && canMoveTo(element.getPosition()) && !isOccupied(element.getPosition())){
//            dataSet.put(element.getPosition(),element);
//            return true;
//        }
//        else {
//            return false;
//        }
//
//    }

//    @Override
//    public void move(StringObject element, MoveDirection direction) {
//        if (!this.dataSet.containsValue(element)){
//            return;
//        }
//
//        final Integer oldPosition = element.getPosition();
//        element.move(direction, this);
//
//        if (oldPosition.equals(element.getPosition()) ){ //there was no move
//            return;
//        }
//
//        dataSet.remove(oldPosition); //remove from map with non updated position (on map)
//        StringObject neighbour = objectAt(element.getPosition()); //obj on new position?
//
//        if (neighbour == null){ //no collision with neighbour, no swap
//            this.place(element);
//        }
//        else { //swap positions
//            this.dataSet.remove(neighbour.getPosition());
//            neighbour.setPosition(oldPosition);
//            this.place(neighbour);
//            this.place(element);
//        }
//    }
//
////    @Override
//    public boolean isOccupied(Integer position) {
//        return this.dataSet.containsKey(position);
//    }

//    @Override
//    public StringObject objectAt(Integer position) {
//        if (!isOccupied(position)){
//            return null;
//        }
//        return this.dataSet.get(position);
//    }

//    @Override
//    public String toString() {
//        String res = "|";
//        for (Integer i=0 ; i < (Integer) mapSize ; i++){
//            StringObject strObj = objectAt(i);
//            if (strObj == null){
//                res += " |";
//            }
//            else {
//                res += strObj.toString() + "|";
//            }
//        }
//        return res;
//    }
}
