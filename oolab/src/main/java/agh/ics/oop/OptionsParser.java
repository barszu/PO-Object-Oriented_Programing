package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.Arrays;

public class OptionsParser {
    // changing input array as str into MoveDirections
    public static MoveDirection[] parse(String[] args) {
        MoveDirection[] directions = new MoveDirection[args.length]; //mallock res array
        int validDirections = 0; //pos to insert in array
        for (String arg : args) {
            switch (arg) {

                case "f": //"forward"
                    directions[validDirections] = MoveDirection.FORWARD;
                    validDirections++;
                    break;
                case "b": //"backward":
                    directions[validDirections] = MoveDirection.BACKWARD;
                    validDirections++;
                    break;
                case "l": // "left":
                    directions[validDirections] = MoveDirection.LEFT;
                    validDirections++;
                    break;
                case "r": // "right":
                    directions[validDirections] = MoveDirection.RIGHT;
                    validDirections++;
                    break;
            }
        }
        return Arrays.copyOfRange(directions, 0, validDirections);
    }
}
