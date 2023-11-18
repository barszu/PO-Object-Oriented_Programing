package agh.ics.oop;

import agh.ics.oop.model.RectangularMap;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.WorldMap;
import agh.ics.oop.my_package.Rectangle;

import java.util.List;

public class World {

    public static void main(String[] main_args) {
        System.out.println("system wystartowal");

        OptionsParser optionsParser = new OptionsParser();
        List<MoveDirection> directions = optionsParser.parse(main_args);

//        run(directions);

//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));

//        Vector2d v = MapDirection.EAST.toUnitVector();
//        System.out.println(v);

//        Animal Andrzej = new Animal();
//        System.out.println(Andrzej.toString());
//        Andrzej.move(MoveDirection.BACKWARD);
//        System.out.println(Andrzej.toString());
//        Andrzej.move(MoveDirection.BACKWARD);
//        System.out.println(Andrzej.toString());
//        Andrzej.move(MoveDirection.BACKWARD);
//        System.out.println(Andrzej.toString());

        //5 task
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        RectangularMap worldMap = new RectangularMap(5,5);
        Simulation simulation = new Simulation(directions, positions, worldMap);
        simulation.run();


        System.out.println("system zakonczyl dzialanie");

    }

    public static void run(List<MoveDirection> directions){
        System.out.println("Start");

        for (MoveDirection direction : directions) {
            switch (direction) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                case RIGHT -> System.out.println("Zwierzak skręca w prawo");
                case LEFT -> System.out.println("Zwierzak skręca w lewo,");
            }
        }
        System.out.println("Stop");
    }
}
