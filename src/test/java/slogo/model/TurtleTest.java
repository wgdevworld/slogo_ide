package slogo.model;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class TurtleTest {

    private Turtle turtle;

    @BeforeEach
    void setUp() {
        turtle = new Turtle();
    }

    @Test
    void testDefaultConstructor() {
        assertEquals(0, turtle.getX());
        assertEquals(0, turtle.getY());
        assertEquals(0, turtle.getDirection());
        assertTrue(turtle.isPenDown());
        assertEquals(Color.BLACK, turtle.getPenColor());
        assertTrue(turtle.isVisible());
    }

    @ParameterizedTest
    @CsvSource({"10, 20, 0", "0, 0, 0", "10, 100, 0"})
    void testParameterizedConstructor(double xi, double yi, double direction) {
        Turtle turtle = new Turtle(xi, yi);
        assertEquals(xi, turtle.getX());
        assertEquals(yi, turtle.getY());
        assertEquals(direction, turtle.getDirection());
        assertTrue(turtle.isPenDown());
        assertEquals(Color.BLACK, turtle.getPenColor());
        assertTrue(turtle.isVisible());
    }

    @Nested
    @DisplayName("Setter and Getter Methods")
    class SetterGetterTests {
        @Test
        void testSetGetX() {
            turtle.setX(50);
            assertEquals(50, turtle.getX());
        }

        @Test
        void testSetGetY() {
            turtle.setY(50);
            assertEquals(50, turtle.getY());
        }

        @Test
        void testSetGetDirection() {
            turtle.setDirection(90);
            assertEquals(90, turtle.getDirection());
            turtle.setDirection(-90);
            assertEquals(270, turtle.getDirection());
            turtle.setDirection(690);
            assertEquals(330, turtle.getDirection());
        }

        @Test
        void testSetGetPenDown() {
            turtle.setPenDown(false);
            assertFalse(turtle.isPenDown());
            turtle.setPenDown(true);
            assertTrue(turtle.isPenDown());
        }

        @Test
        void testSetGetVisibility() {
            turtle.setVisibility(false);
            assertFalse(turtle.isVisible());
            turtle.setVisibility(true);
            assertTrue(turtle.isVisible());
        }

        @ParameterizedTest
        @CsvSource({"36, 40", "0, 0", "200, 100"})
        void testSetPosition(double xpos, double ypos) {
            turtle.setPosition(xpos, ypos);
            assertEquals(xpos, turtle.getX());
            assertEquals(ypos, turtle.getY());
        }

        @Test
        void testSetGetPenColor() {
            turtle.setPenColor(Color.RED);
            assertEquals(Color.RED, turtle.getPenColor());
            turtle.setPenColor(Color.BLACK);
            assertEquals(Color.BLACK, turtle.getPenColor());
        }

        @ParameterizedTest
        @CsvSource({"90", "180", "-270", "360"})
        void testRotate(double degrees) {
            double expected = (turtle.getDirection() + degrees) % 360;
            turtle.rotate(degrees);
            assertEquals(expected, turtle.getDirection());
        }

        @Test
        void testClearScreen() {
            turtle.clearScreen();
            assertEquals(0, turtle.getX());
            assertEquals(0, turtle.getY());
            assertEquals(0, turtle.getDirection());
            assertTrue(turtle.isPenDown());
            assertTrue(turtle.isVisible());
        }
    }


}