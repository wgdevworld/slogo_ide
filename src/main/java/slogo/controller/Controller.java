package slogo.controller;

import java.awt.Dimension;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import slogo.Main;
import slogo.model.Turtle;
import slogo.model.parsers.InputParser;
import slogo.view.View;

/**
 * Purpose:
 * <p> Controller that creates new instance of view and turtle and connects them.
 * Assumptions:
 * <p> None
 * Dependencies:
 * <p> View, Turtle
 * @author Woonggyu Jin
 */


public class Controller implements TurtleObserver {
  private static Dimension DEFAULT_SIZE;

  private static final String REFLECTION_RESOURCES = "ReflectionActions";
  private static final String DIMENSION_RESOURCES = "Dimensions";
  private static final String TITLE = "Slogo";
  private Turtle turtle;
  private View myView;
  private Stage myStage;
  private static ResourceBundle myReflectionResources;
  private static ResourceBundle myDimensionResources;
  private static InputParser myInputParser;

  public Controller(String language, Stage stage) {
    myStage = stage;
    myReflectionResources = ResourceBundle.getBundle(
        Main.DEFAULT_RESOURCE_PACKAGE + REFLECTION_RESOURCES);
    myDimensionResources = ResourceBundle.getBundle(Main.DEFAULT_RESOURCE_PACKAGE + DIMENSION_RESOURCES);
    myView = new View(language);
    myInputParser = new InputParser();
    turtle = myInputParser.getTurtle();
    myInputParser.addObserver(this);
    myView.setController(this);
    DEFAULT_SIZE = getDimensions("Stage");
    myStage.setResizable(false);
    myStage.setScene(myView.makeScene(DEFAULT_SIZE.width, DEFAULT_SIZE.height));
    myStage.setTitle(TITLE);
    myStage.show();
  }

  /**
   * Purpose:
   * <p> Update the observer of a change in the state of the turtle
   * Assumptions:
   * <p> None
   * Parameters:
   * <p> None
   * Exceptions:
   * <p> None
   * Return:
   * <p> None
   * @author Woonggyu Jin
   */
  @Override
  public void updateTurtleState() {
    double x = turtle.getX();
    double y = turtle.getY();
    double direction = turtle.getDirection();
    boolean penDown = turtle.isPenDown();
    Color penColor = turtle.getPenColor();
    boolean visible = turtle.isVisible();
//    System.out.println(
//        "x:" + String.valueOf(x) + ", y: " + String.valueOf(y) + ", direction: " + String.valueOf(
//            direction) + ", isPenDown: " + penDown + ", pen color:" + String.valueOf(penColor)
//            + ", visible: " + String.valueOf(visible));
    myView.getTurtleGraphic().updateTurtleGraphics(x, y, direction, penDown, penColor, visible);
  }

  /**
   * Purpose:
   * <p> Set the event handler to be handled by the command input text field in View.
   * Assumptions:
   * <p> To be used only for the text field that takes in command.
   * Parameters:
   * <p> TextField
   * Exceptions:
   * <p> Thrown if method does not exist in properties file or if the target for which the method
   * was invoked is invalid.
   * Return:
   * <p> None
   * @author Woonggyu Jin
   */
  public void setInputMethod(TextField textField) {
    // Add an event listener to the TextField that listens for the Enter key press event
    textField.setOnAction(e -> {
      Method method = null;
        // Invoke the specified method on the target object using reflection
        String methodName = myReflectionResources.getString(textField.getId());
      try {
        method = Controller.this.getClass().getDeclaredMethod(methodName, String.class);
      } catch (NoSuchMethodException ex) {
        throw new RuntimeException(ex);
      }
      String userInput = textField.getText();
      try {
        method.invoke(Controller.this, userInput);
      } catch (IllegalAccessException | InvocationTargetException ex) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Please enter a correct command.");
        alert.showAndWait();
      }
      textField.clear();
    });
  }

  /**
   * Purpose:
   * <p> Make color picker that is instantiated in the view to change pen color
   * Assumptions:
   * <p> None
   * Parameters:
   * <p> ColorPicker
   * Exceptions:
   * <p> None
   * Return:
   * <p> None
   * @author Woonggyu Jin
   */
  public void setColorMethod(ColorPicker colorPicker) {
    colorPicker.setOnAction((EventHandler) t -> {
      turtle.setPenColor(colorPicker.getValue());
      updateTurtleState();
    }
    );
  }

  /**
   * Purpose:
   * <p> Set the event handler to be handled by a button in View.
   * Assumptions:
   * <p> None
   * Parameters:
   * <p> None
   * Exceptions:
   * <p>Thrown if method does not exist in properties file or if the target for which the method
   * was invoked is invalid.
   * Return:
   * <p> None
   * @author Woonggyu Jin
   */
  public void setButtonMethod(Button button) {
    button.setOnAction(e -> {
        // Invoke the specified method on the target object using reflection
        String methodName = myReflectionResources.getString(button.getId());
      Method method = null;
      try {
        method = Controller.this.getClass().getDeclaredMethod(methodName);
      } catch (NoSuchMethodException ex) {
        throw new RuntimeException("No method called " + methodName);
      }
      try {
        method.invoke(Controller.this);
      } catch (IllegalAccessException | InvocationTargetException ex) {
        throw new SlogoException("Invalid Slogo command");
      }
    });
  }

  private void handleInput(String userInput) throws Exception {
    myInputParser.parseProgramCode(userInput);
    myView.getMyText().appendText(userInput + "\n");
    updateTurtleState();
  }

  /**
   * Purpose:
   * <p> Get the dimensions of the component specified by the parameter from properties file.
   * Assumptions:
   * <p> None
   * Parameters:
   * <p> None
   * Exceptions:
   * <p> None
   * Return:
   * <p> Dimension
   * @author Woonggyu Jin
   */
  public Dimension getDimensions(String property) {
    List<String> dimensionList = Arrays.asList(myDimensionResources.getString(property).split(","));
    return new Dimension(Integer.parseInt(dimensionList.get(0)),
        Integer.parseInt(dimensionList.get(1)));
  }

  /**
   * Purpose:
   * <p> Get the view associated with the controller
   * Assumptions:
   * <p> None
   * Parameters:
   * <p> None
   * Exceptions:
   * <p> None
   * Return:
   * <p> View
   * @author Woonggyu Jin
   */
  public View getMyView() {
    return myView;
  }

  private void clear() throws Exception {
    turtle.clearScreen();
    myView.getTurtleGraphic().updateTurtleGraphics(turtle.getX(), turtle.getY(),
        turtle.getDirection(), false, turtle.getPenColor(), turtle.isVisible());
    myView.getTurtleGraphic().clearCanvas();

  }

  private void stop() {
    myView.getTurtleGraphic().getAnimation().play();
  }

  private void pause() {
    myView.getTurtleGraphic().getAnimation().pause();
  }

  private void penUp() throws Exception {
    handleInput("penup");
    updateTurtleState();
  }

  private void penDown() throws Exception {
    handleInput("pendown");
    updateTurtleState();
  }

  private void forwards() {
    CompletableFuture<Integer> futureInput = myView.generateInputPopup(myStage);
    futureInput.thenAccept(input -> {
      try {
        handleInput("fd " + input);
      } catch (Exception e) {
        throw new SlogoException("Invalid Slogo command");
      }
    });
  }
  private void backwards() {
    CompletableFuture<Integer> futureInput = myView.generateInputPopup(myStage);
    futureInput.thenAccept(input -> {
      try {
        handleInput("bk " + input);
      } catch (Exception e) {
        throw new SlogoException("Invalid Slogo command");
      }
    });
  }

  private void leftTurn() {
    CompletableFuture<Integer> futureInput = myView.generateInputPopup(myStage);
    futureInput.thenAccept(input -> {
      try {
        handleInput("lt " + input);
      } catch (Exception e) {
        throw new SlogoException("Invalid Slogo command");
      }
    });
  }

  private void rightTurn() {
    CompletableFuture<Integer> futureInput = myView.generateInputPopup(myStage);
    futureInput.thenAccept(input -> {
      try {
        handleInput("rt " + input);
      } catch (Exception e) {
        throw new SlogoException("Invalid Slogo command");
      }
    });
  }

}
