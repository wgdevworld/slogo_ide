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

  public Turtle() {
    x = 0;
    y = 0;
    direction = 0;
    penDown = true;
    penColor = Color.BLACK;
    visible = true;
  }

  public Turtle(double xi, double yi) {
    x = xi;
    y = yi;
    direction = 0;
    penDown = true;
    penColor = Color.BLACK;
    visible = true;
  }

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  public double getDirection() {
    return direction;
  }

  public void clearScreen() {
    x = 0;
    y = 0;
    direction = 0;
    penDown = true;
    visible = true;
  }

  public void setDirection(double direction) {
    this.direction = direction % 360; // ensure direction is in range [0, 360)
  }

  public boolean isPenDown() {
    return penDown;
  }

  public void setPenDown(boolean penDown) {
    this.penDown = penDown;
  }

  public boolean isVisible() {
    return visible;
  }

  public void setVisibility(boolean visible) {
    this.visible = visible;
  }

  public void setPosition(double x, double y) {
    setX(x);
    setY(y);
  }

  public Color getPenColor() {
    return penColor;
  }

  public void setPenColor(Color penColor) {
    this.penColor = penColor;
  }

  // Rotate the turtle by a given angle
  public void rotate(double angle) {
    direction += angle;
    direction %= 360; // ensure direction is in range [0, 360)
  }
}

