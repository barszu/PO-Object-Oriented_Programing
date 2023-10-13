package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {
    public static void main(String[] main_args) {
        System.out.println("system wystartowal");

        OptionsParser optionsParser = new OptionsParser();
        MoveDirection[] directions = optionsParser.parse(main_args);

        run(directions);

        System.out.println("system zakonczyl dzialanie");

    }

    public static void run(MoveDirection[] directions){
        System.out.println("Start");

        for(int i=0 ; i< directions.length ; i++){
            switch (directions[i]){
                case FORWARD: System.out.println("Zwierzak idzie do przodu"); break;
                case BACKWARD: System.out.println("Zwierzak idzie do tyłu"); break;
                case RIGHT: System.out.println("Zwierzak skręca w prawo"); break;
                case LEFT: System.out.println("Zwierzak skręca w lewo,"); break;
                default:
            }

        }
        System.out.println("Stop");
    }
}
