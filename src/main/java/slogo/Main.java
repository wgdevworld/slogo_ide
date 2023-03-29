package slogo;

import java.awt.Dimension;
import javafx.application.Application;
import javafx.stage.Stage;
import slogo.controller.Controller;
import slogo.model.Turtle;
import slogo.view.View;

/**
 * Purpose:
 * <p> Create a new instance of the controller and run program
 * Assumptions:
 * <p> User will provide language by typing it in the code
 * Dependencies:
 * <p> Controller
 * @author Woonggyu Jin
 */

public class Main extends Application {
  public static final String DEFAULT_RESOURCE_PACKAGE = "slogo/view/";
  public static final String DEFAULT_LANGUAGE = "English";


  /**
   * Purpose:
   * <p> Start program
   * Assumptions:
   * <p> None
   * Parameters:
   * <p> Stage for program to run
   * Exceptions:
   * <p> None
   * Return:
   * <p> None
   * @author Woonggyu Jin
   */
  @Override
  public void start (Stage stage) {
    Controller controller = new Controller(DEFAULT_LANGUAGE, stage);
  }
}