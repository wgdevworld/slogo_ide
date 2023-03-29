/**
 * The Turtle class represents a turtle that can move and draw on a canvas. It stores the turtle's
 * current position, direction, pen state, pen color, and visibility.
 */
package slogo.model;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;
import slogo.controller.TurtleObserver;

public class Turtle {

    private double x;
    private double y;
    private double direction;
    private boolean penDown;
    private Color penColor;
    private boolean visible;
    private List<TurtleObserver> observers = new ArrayList<>();

    /**
     * Constructs a new Turtle with default position (0, 0), direction 0, pen down, black pen color,
     * and visible.
     */
    public Turtle() {
        x = 0;
        y = 0;
        direction = 0;
        penDown = true;
        penColor = Color.BLACK;
        visible = true;
    }

    /**
     * Constructs a new Turtle with the given initial position and default direction 0, pen down,
     * black pen color, and visible.
     *
     * @param xi the initial x position of the turtle
     * @param yi the initial y position of the turtle
     */
    public Turtle(double xi, double yi) {
        x = xi;
        y = yi;
        direction = 0;
        penDown = true;
        penColor = Color.BLACK;
        visible = true;
    }

    /**
     * Returns the x-coordinate of the turtle's current position.
     *
     * @return the x-coordinate of the turtle's current position
     */
    public double getX() {
        return x;
    }

    /**
     * Sets the x-coordinate of the turtle's current position.
     *
     * @param x the x-coordinate of the turtle's new position
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Returns the y-coordinate of the turtle's current position.
     *
     * @return the y-coordinate of the turtle's current position
     */
    public double getY() {
        return y;
    }

    /**
     * Sets the y-coordinate of the turtle's current position.
     *
     * @param y the y-coordinate of the turtle's new position
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Returns the current direction of the turtle in degrees.
     *
     * @return the current direction of the turtle in degrees
     */
    public double getDirection() {
        return direction;
    }

    /**
     * Clears the screen by setting the turtle's position to (0, 0), direction to 0, pen down, and
     * visible.
     */
    public void clearScreen() {
        x = 0;
        y = 0;
        direction = 0;
        penDown = true;
        visible = true;
    }

    /**
     * Sets the turtle's direction to the given angle in degrees. The angle is normalized to be within
     * the range [0, 360).
     *
     * @param direction the new direction of the turtle in degrees
     */
    public void setDirection(double direction) {
        this.direction = direction % 360; // ensure direction is in range [0, 360)
        if (this.direction < 0.0) {
            this.direction += 360.0;
        }
    }

    /**
     * Returns whether the turtle's pen is currently down.
     *
     * @return true if the turtle's pen is down, false if it is up
     */
    public boolean isPenDown() {
        return penDown;
    }

    /**
     * Sets the turtle's pen state to either up or down.
     *
     * @param penDown true if the turtle's pen should be down, false if it should be up
     */
    public void setPenDown(boolean penDown) {
        this.penDown = penDown;
    }

    /**
     * Returns whether the turtle is currently visible on the canvas.
     *
     * @return true if the turtle is visible, false if it is hidden
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * Sets whether the turtle should be visible on the canvas.
     *
     * @param visible true if the turtle should be visible, false if it should be hidden
     */
    public void setVisibility(boolean visible) {
        this.visible = visible;
    }

    /**
     * Sets the turtle's position to the given coordinates.
     *
     * @param x the new x-coordinate of the turtle's position
     * @param y the new y-coordinate of the turtle's position
     */
    public void setPosition(double x, double y) {
        setX(x);
        setY(y);
    }

    /**
     * Returns the current pen color of the turtle.
     *
     * @return the current pen color of the turtle
     */
    public Color getPenColor() {
        return penColor;
    }

    /**
     * Sets the turtle's pen color to the given color.
     *
     * @param penColor the new pen color of the turtle
     */
    public void setPenColor(Color penColor) {
        this.penColor = penColor;
    }

    /**
     * Rotates the turtle by the given angle in degrees.
     *
     * @param angle the angle by which to rotate the turtle in degrees
     */
    public void rotate(double angle) {
        direction += angle;
        direction %= 360; // ensure direction is in range [0, 360)
    }
}