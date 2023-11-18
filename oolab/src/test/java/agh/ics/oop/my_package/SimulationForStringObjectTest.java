package agh.ics.oop.my_package;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationForStringObjectTest {

    @Test
    void runtest1() { //messy args
        String[] args = {"f", "b", "l", "r","b","l","r","x","x"};

        List<MoveDirection> movesList = OptionsParser.parse(args);
        List<Integer> positionsList = List.of(1);
        List<String> namesList = List.of("abc");
        TextMap worldMap = new TextMap(5);

        SimulationForStringObject simulation = new SimulationForStringObject(movesList, positionsList, namesList ,worldMap);

        simulation.run(); //working as void on animals list

        StringObject obj1 = simulation.getStrObjList().get(0);

        assertEquals(MapDirection.NORTH , obj1.getDirection());
        assertEquals( 1 , obj1.getPosition());

    }

    @Test
    void runtest2() { //check border
        String[] args = {"r","f","f","f","f","f","f"};

        List<MoveDirection> movesList = OptionsParser.parse(args);
        List<Integer> positionsList = List.of(1);
        List<String> namesList = List.of("abc");
        TextMap worldMap = new TextMap(5);

        SimulationForStringObject simulation = new SimulationForStringObject(movesList, positionsList, namesList ,worldMap);

        simulation.run(); //working as void on animals list

        StringObject obj1 = simulation.getStrObjList().get(0);

        assertEquals(obj1.getDirection(), MapDirection.EAST);
        assertEquals(obj1.getPosition(), 4 );

    }

    @Test
    void runtest3() { //check border, swaping
        String[] args = {"r","f","f","f","f","f","f","l","b","b"};

        List<MoveDirection> movesList = OptionsParser.parse(args);
        List<Integer> positionsList = List.of(1 , 2);
        List<String> namesList = List.of("a" , "b");
        TextMap worldMap = new TextMap(5);

        SimulationForStringObject simulation = new SimulationForStringObject(movesList, positionsList, namesList ,worldMap);

        simulation.run(); //working as void on animals list

        StringObject obj1 = simulation.getStrObjList().get(0);

        assertEquals(obj1.getDirection(), MapDirection.EAST);
        assertEquals(obj1.getPosition(), 3 );

        StringObject obj2 = simulation.getStrObjList().get(1);

        assertEquals(obj2.getDirection(), MapDirection.WEST);
        assertEquals(obj2.getPosition(), 2 );
    }

    @Test
    void runtest4() { //check border, swaping
        String[] args = {"r","r","r", "l","f","l" , "l","f","l" , "l","f","l"};

        List<MoveDirection> movesList = OptionsParser.parse(args);
        List<Integer> positionsList = List.of(0 , 1 , 2);
        List<String> namesList = List.of("Ala", "ma", "sowoniedzwiedzia");
        TextMap worldMap = new TextMap(3);

        SimulationForStringObject simulation = new SimulationForStringObject(movesList, positionsList, namesList ,worldMap);

        simulation.run(); //working as void on animals list

        StringObject obj1 = simulation.getStrObjList().get(0);
        StringObject obj2 = simulation.getStrObjList().get(1);
        StringObject obj3 = simulation.getStrObjList().get(2);

        assertEquals(obj1.getPosition(), 0 );
        assertEquals(obj2.getPosition(), 2 );
        assertEquals(obj3.getPosition(), 1 );
    }
}