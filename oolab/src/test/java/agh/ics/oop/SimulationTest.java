package agh.ics.oop;

import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.Animal;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    @Test
    void testRun1() { //messy args
        String[] args = {"f", "b", "l", "r","b","l","r","x","x"};
        List<MoveDirection> movesList = OptionsParser.parse(args);
        List<Vector2d> positionsList = List.of(new Vector2d(2, 2),new Vector2d(0, 0));
        Simulation simulation = new Simulation(movesList, positionsList);

        simulation.run(); //working as void on animals list

        Animal animal1 = simulation.getAnimalsList().get(0);
        Animal animal2 = simulation.getAnimalsList().get(1);

        assertEquals(animal1.getDirection(), MapDirection.NORTH);
        assertEquals(animal1.getPosition(), new Vector2d(3, 3) );

        assertEquals(animal2.getDirection(), MapDirection.NORTH);
        assertEquals(animal2.getPosition(), new Vector2d(0, 0) );


    }

    @Test
    void testRun2() { //no args
        String[] args = {};
        List<MoveDirection> movesList = OptionsParser.parse(args);
        List<Vector2d> positionsList = List.of(new Vector2d(2, 2),new Vector2d(0, 0));
        Simulation simulation = new Simulation(movesList, positionsList);

        simulation.run(); //working as void on animals list

        Animal animal1 = simulation.getAnimalsList().get(0);
        Animal animal2 = simulation.getAnimalsList().get(1);

        assertEquals(animal1.getDirection(), MapDirection.NORTH);
        assertEquals(animal1.getPosition(), new Vector2d(2, 2) );

        assertEquals(animal2.getDirection(), MapDirection.NORTH);
        assertEquals(animal2.getPosition(), new Vector2d(0, 0) );


    }

    @Test
    void testRun3() { //border blocking check
        String[] args = {"f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f",};
        List<MoveDirection> movesList = OptionsParser.parse(args);
        List<Vector2d> positionsList = List.of(new Vector2d(2, 2));
        Simulation simulation = new Simulation(movesList, positionsList);

        simulation.run(); //working as void on animals list

        Animal animal1 = simulation.getAnimalsList().get(0);

        assertEquals(animal1.getDirection(), MapDirection.NORTH);
        assertEquals(animal1.getPosition(), new Vector2d(2, 4) );
    }

    @Test
    void testRun4() { //no animals
        String[] args = {"f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f",};
        List<MoveDirection> movesList = OptionsParser.parse(args);
        List<Vector2d> positionsList = List.of();
        Simulation simulation = new Simulation(movesList, positionsList);

        simulation.run(); //working as void on animals list

        assertEquals(simulation.getAnimalsList().size() , 0);
    }

}