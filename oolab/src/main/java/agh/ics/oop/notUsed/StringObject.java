package agh.ics.oop.notUsed;

import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.MoveValidator;
import agh.ics.oop.model.Vector2d;

public class StringObject {
//    private MapDirection direction ;
//    private String name;
//
//    public MapDirection getDirection() {
//        return direction;
//    }
//
//    public Integer getPosition() {
//        return position;
//    }
//
//    public void setPosition(Integer position) {
//        this.position = position;
//    }
//
//    private Integer position;
//
//    public StringObject(){
//        this.direction = MapDirection.NORTH;
//        this.name = "";
//        this.position = 1;
//    }
//
//    public StringObject(String  name , Integer pos){
//        this.direction = MapDirection.NORTH;
//        this.name = name;
//        this.position = pos;
//    }
//
//    public StringObject(String  name , Integer pos ,MapDirection direction ){
//        this.direction = direction;
//        this.name = name;
//        this.position = pos;
//    }
//
//    public void move(MoveDirection direction, MoveValidator moveValidator){
//        Integer newPosition = this.position;
//        switch (direction){
//            //changing direction by rotation
//            case RIGHT -> this.direction = this.direction.next();
//            case LEFT -> this.direction = this.direction.previous();
//            //changing position, go forward/backward with no rotation
//            case FORWARD -> {
//                switch (this.direction){
//                    //for NORTH and SOUTH nothing to do
//                    case WEST -> newPosition += -1;
//                    case EAST -> newPosition += 1;
//                }
//            }
//            case BACKWARD -> {
//                switch (this.direction){
//                    //for NORTH and SOUTH nothing to do
//                    case WEST -> newPosition += 1;
//                    case EAST -> newPosition += -1;
//                }
//            }
//        }
//        if (moveValidator.canMoveTo(newPosition)){
//            this.position = newPosition;
//        }
//    }
//
//
//    @Override
//    public String toString() {
//        return "(" + name + ")" + direction.toString() + position;
//    }

}
