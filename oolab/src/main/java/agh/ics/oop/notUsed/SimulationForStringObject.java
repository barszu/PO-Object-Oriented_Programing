package agh.ics.oop.notUsed;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimulationForStringObject {
//    private final List<MoveDirection> directionsList; //moves for animals
//    private final List<StringObject> strObjList; //animals in the simulation
//    private final WorldMap worldMap;

//    public List<StringObject> getStrObjList() {
//        return Collections.unmodifiableList(strObjList);
//    }


//    public SimulationForStringObject(List<MoveDirection> directionsList , List<Integer> positionsList , List<String> namesList , TextMap worldMap ){
//        this.directionsList = directionsList; //as link list
//        this.strObjList = new ArrayList<>(); //as normal list because we will pick el from the middle
//        this.worldMap = worldMap;
//
//        int i = 0;
//        for (Integer position: positionsList){
//            if (this.worldMap.canMoveTo(position)){ //pos in bound
//                StringObject stringObj = new StringObject(namesList.get(i), position);
//                strObjList.add(stringObj);
//                worldMap.place(stringObj);
//            }
//            //else skip that StrObj
//            i++ ;
//
//        }
//    }
//
//    public void run(){
//        int strObjIdx = 0 ;
//        if (this.strObjList.size() == 0){ return;} //nothing to do, no animals present
//        for (MoveDirection direction: this.directionsList){ //if no moves 'for' won't start
//            // strobj on strObjIdx gets moved
//            StringObject strObj = this.strObjList.get(strObjIdx);
//            this.worldMap.move(strObj,direction);
//
////            System.out.println("StrObj %d: %s".formatted(strObjIdx , strObj.toString() ));
//
//            strObjIdx ++ ;
//            if (strObjIdx >= this.strObjList.size()){
//                strObjIdx = 0 ; //reset idx for repetition
//            }
//
//        }
////        String toprint = this.worldMap.toString();
////        System.out.print(toprint);
//    }
}
