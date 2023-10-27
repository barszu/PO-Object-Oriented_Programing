package agh.ics.oop.my_package;

import agh.ics.oop.model.Vector2d;

//my own class for easy check if point (Animal.position) is in the Word map
//and for global settings -> if I decide to change map size
public class BorderBox {
    //designating a field just like selecting a part of the screen by mouse
    private final Vector2d startPoint; //left,up most point
    private final Vector2d endPoint; //right,down most point

    public static final int WORLD_MAP_SIZE = 4; //GLOBAL SETTING, can be changed

    public BorderBox(){
        this.startPoint = new Vector2d(0,0);
        this.endPoint = new Vector2d(WORLD_MAP_SIZE , WORLD_MAP_SIZE);
    }

    public BorderBox(Vector2d startPoint , Vector2d endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public boolean contains(Vector2d point){
        // if point is Null it will crash on Vector2d
        // variables for easy code
        Vector2d borderLeftDown = this.startPoint.lowerLeft(this.endPoint);
        Vector2d borderRightUp = this.startPoint.upperRight(this.endPoint);

        return point.precedes(borderRightUp) && point.follows(borderLeftDown);
    }
}
