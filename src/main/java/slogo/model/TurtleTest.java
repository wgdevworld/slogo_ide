package slogo.model;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TurtleTest {

    @Test
    void testDefaultConstructor() {
        Turtle turtle = new Turtle();
        assertEquals(0, turtle.getX());
        assertEquals(0, turtle.getY());
        assertEquals(0, turtle.getDirection());
        assertTrue(turtle.isPenDown());
        assertEquals(Color.BLACK, turtle.getPenColor());
        assertTrue(turtle.isVisible());
    }

    @Test
    void testParameterizedConstructor() {
        Turtle turtle = new Turtle(10, 20);
        assertEquals(10, turtle.getX());
        assertEquals(20, turtle.getY());
        assertEquals(0, turtle.getDirection());
        assertTrue(turtle.isPenDown());
        assertEquals(Color.BLACK, turtle.getPenColor());
        assertTrue(turtle.isVisible());
    }

    @Test
    void testSetX() {
        Turtle turtle = new Turtle();
        turtle.setX(50);
        assertEquals(50, turtle.getX());
    }

    @Test
    void testSetY() {
        Turtle turtle = new Turtle();
        turtle.setY(50);
        assertEquals(50, turtle.getY());
    }

    @Test
    void testSetDirection() {
        Turtle turtle = new Turtle();
        turtle.setDirection(90);
        assertEquals(90, turtle.getDirection());
        turtle.setDirection(-90);
        assertEquals(-90, turtle.getDirection());
    }

    @Test
    void testSetPenDown() {
        Turtle turtle = new Turtle();
        turtle.setPenDown(false);
        assertFalse(turtle.isPenDown());
    }

    @Test
    void testSetVisibility() {
        Turtle turtle = new Turtle();
        turtle.setVisibility(false);
        assertFalse(turtle.isVisible());
    }

    @Test
    void testSetPosition() {
        Turtle turtle = new Turtle();
        turtle.setPosition(10, 20);
        assertEquals(10, turtle.getX());
        assertEquals(20, turtle.getY());
    }

    @Test
    void testSetPenColor() {
        Turtle turtle = new Turtle();
        turtle.setPenColor(Color.RED);
        assertEquals(Color.RED, turtle.getPenColor());
    }

    @Test
    void testRotate() {
        Turtle turtle = new Turtle();
        turtle.rotate(90);
        assertEquals(90, turtle.getDirection());
        turtle.rotate(360);
        assertEquals(90, turtle.getDirection());
        turtle.rotate(-180);
        assertEquals(-90, turtle.getDirection());
    }
}