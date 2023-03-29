package slogo.view;

import java.util.Objects;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import slogo.Main;
import slogo.controller.Controller;
import slogo.model.Turtle;
import org.apache.commons.lang3.tuple.Triple;
import java.util.ArrayList;
import java.util.List;

public class TurtleGraphics {

  private static double CANVAS_WIDTH;
  private static double CANVAS_HEIGHT;

  private ResourceBundle myImageResources;
  private Controller myController;
  private Timeline animation;
  private Color myColor;
  private boolean isVisible;
  private double myDirection;
  private GraphicsContext gc;
  private TurtleImage myTurtleImage;

  private List<Triple<Double, Double, Boolean>> tupleList;
  private double oldX;
  private double oldY;
  private int tupleIndex = 0;
  private Canvas myCanvas;

  public TurtleGraphics(double initialX, double initialY, String property, Controller controller) {
    myController = controller;
    oldX = initialX;
    oldY = initialY;
    tupleList = new ArrayList<>();
    myCanvas = new Canvas();
    myCanvas.setId("Canvas");
    CANVAS_WIDTH = myController.getDimensions(myCanvas.getId()).getWidth();
    CANVAS_HEIGHT = myController.getDimensions(myCanvas.getId()).getHeight();

    myCanvas.setWidth(CANVAS_WIDTH);
    myCanvas.setHeight(CANVAS_HEIGHT);
    myTurtleImage = new TurtleImage();
    gc = myCanvas.getGraphicsContext2D();
    gc.setFill(Color.WHITE);
    gc.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
  }

  public Canvas setCanvas() {

    return myCanvas;
  }

  public ImageView setTurtle() {
    myTurtleImage.home();
    return myTurtleImage;
  }

  public void clearCanvas() {
    gc.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
    gc.setFill(Color.WHITE);
    gc.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
    myTurtleImage.home();
  }

  public Timeline getAnimation() {
    return animation;
  }

  //list idea from chatGPT
  public void updateTurtleGraphics(double x, double y, double direction,
      boolean penDown, Color penColor, boolean visible) {
    myColor = penColor;
    isVisible = visible;
    myDirection = direction;

    if (!tupleList.isEmpty()) {
      oldX = tupleList.get(tupleIndex).getLeft();
      oldY = tupleList.get(tupleIndex).getMiddle();
      tupleIndex++;
    }

    // add elements to the list
    tupleList.add(Triple.of(x, y, penDown));
    draw(gc, tupleIndex, penDown);
    myTurtleImage.rotate(direction);
  }

  //draw idea from chatGPT
  private void draw(GraphicsContext gc, int index, boolean penDown) {
    gc.setStroke(myColor);
    gc.setLineWidth(2);

    double newX = tupleList.get(index).getLeft();
    double newY = tupleList.get(index).getMiddle();
    if (isVisible) {
      myTurtleImage.show();
      myTurtleImage.move(newX, newY);
    }
    else {
      myTurtleImage.hide();
    }
    if (penDown) {
      gc.strokeLine(oldX + CANVAS_WIDTH / 2, oldY + CANVAS_HEIGHT / 2, newX + CANVAS_WIDTH / 2,
          newY + CANVAS_HEIGHT / 2);
    }
  }


}
