package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {
    @Test
    public void testParseValidDirections() {
        String[] args = {"f", "b", "l", "r"};
        MoveDirection[] expected = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.RIGHT};
        MoveDirection[] result = OptionsParser.parse(args);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testParseInvalidDirections() {
        String[] args = {"f", "b", "x", "r"};
        MoveDirection[] expected = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT};
        MoveDirection[] result = OptionsParser.parse(args);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testParseEmptyArray() {
        String[] args = {};
        MoveDirection[] expected = {};
        MoveDirection[] result = OptionsParser.parse(args);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testParseNullArray() {

        String[] args = null;
        try {
            MoveDirection[] result = OptionsParser.parse(args);
        } catch (NullPointerException e) {
            assertTrue(true);
        }

    }

}