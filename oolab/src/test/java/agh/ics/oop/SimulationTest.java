package agh.ics.oop;

import agh.ics.oop.model.*;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    @Test
    void testRun1() { //messy args
        String[] args = {"f", "b", "l", "r","b","l","r","x","x"};
        List<MoveDirection> movesList = OptionsParser.parse(args);
        List<Vector2d> positionsList = List.of(new Vector2d(2, 2),new Vector2d(0, 0));
        RectangularMap worldMap = new RectangularMap(5,5);

        Simulation simulation = new Simulation(movesList, positionsList, worldMap);

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
        RectangularMap worldMap = new RectangularMap(5,5);

        Simulation simulation = new Simulation(movesList, positionsList, worldMap);

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
        RectangularMap worldMap = new RectangularMap(5,5);

        Simulation simulation = new Simulation(movesList, positionsList, worldMap);

        simulation.run(); //working as void on animals list

        Animal animal1 = simulation.getAnimalsList().get(0);

        assertEquals(animal1.getDirection(), MapDirection.NORTH);
        assertEquals(animal1.getPosition(), new Vector2d(2, 5) );
    }

    @Test
    void testRun4() { //no animals
        String[] args = {"f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f"};
        List<MoveDirection> movesList = OptionsParser.parse(args);
        List<Vector2d> positionsList = List.of();
        RectangularMap worldMap = new RectangularMap(5,5);

        Simulation simulation = new Simulation(movesList, positionsList, worldMap);

        simulation.run(); //working as void on animals list

        assertEquals(simulation.getAnimalsList().size() , 0);
    }

    @Test
    void testRun5() { //weird rectangle, no animals added to map
        String[] args = {"f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","l"};
        List<MoveDirection> movesList = OptionsParser.parse(args);
        List<Vector2d> positionsList = List.of(new Vector2d(2, 2));
        RectangularMap worldMap = new RectangularMap(1,100);

        Simulation simulation = new Simulation(movesList, positionsList, worldMap);

        simulation.run(); //working as void on animals list

        assertEquals(simulation.getAnimalsList().size() , 0);

    }

    @Test
    void testRun6() { //weird rectangle, box borders not soft check
        String[] args = {"f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","l"};
        List<MoveDirection> movesList = OptionsParser.parse(args);
        List<Vector2d> positionsList = List.of(new Vector2d(1, 1));
        RectangularMap worldMap = new RectangularMap(1,100);

        Simulation simulation = new Simulation(movesList, positionsList, worldMap);

        simulation.run(); //working as void on animals list

        Animal animal1 = simulation.getAnimalsList().get(0);

        assertEquals(MapDirection.WEST , animal1.getDirection() );
        assertEquals(new Vector2d(1, 17) , animal1.getPosition() );

    }

    @Test
    void testRun7() { //rectangle with 1 width, box borders not soft check
        String[] args = {"f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","l"};
        List<MoveDirection> movesList = OptionsParser.parse(args);
        List<Vector2d> positionsList = List.of(new Vector2d(0, 1));
        RectangularMap worldMap = new RectangularMap(1,100);

        Simulation simulation = new Simulation(movesList, positionsList, worldMap);

        simulation.run(); //working as void on animals list

        Animal animal1 = simulation.getAnimalsList().get(0);

        assertEquals(MapDirection.WEST , animal1.getDirection() );
        assertEquals(new Vector2d(0, 17) , animal1.getPosition() );

    }

    @Test
    void testRun8() { //rectangle with negative width
        String[] args = {"f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","l"};
        List<MoveDirection> movesList = OptionsParser.parse(args);
        List<Vector2d> positionsList = List.of(new Vector2d(-1, 1));

        try {
            RectangularMap worldMap = new RectangularMap(-1,100);
            assertTrue(false);
        }
        catch (IllegalArgumentException e){
            assertTrue(true);
        }
    }

    @Test
    void testRun9() { //animals stacking on each other on spawn
        String[] args = {"f", "b", "l", "r","b","l","r","x","x"};
        List<MoveDirection> movesList = OptionsParser.parse(args);
        List<Vector2d> positionsList = List.of(new Vector2d(2, 2),new Vector2d(2, 2));
        RectangularMap worldMap = new RectangularMap(5,5);

        Simulation simulation = new Simulation(movesList, positionsList, worldMap);

        simulation.run(); //working as void on animals list

        assertEquals(1 , simulation.getAnimalsList().size());


    }

}