package slogo.view;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import slogo.Main;
import slogo.controller.Controller;

/**
 * Purpose:
 * <p> Creating the view component of the program
 * Assumptions:
 * <p> None
 * Dependencies:
 * <p> Controller, TurtleGraphics
 *
 * @author Woonggyu Jin, Charles Turpin
 */

public class View {

  private static final String DEFAULT_STYLESHEET =
          "/" + Main.DEFAULT_RESOURCE_PACKAGE.replace(".", "/") + "Default.css";
  private static final String PANEL_RESOURCES = "PanelActions";
  private static final String DRAWER = "Turtle";


  private ResourceBundle myLanguageResources;
  private ResourceBundle myPanelResources;

  private TextField myCommandDisplay;
  private Controller myController;
  private TurtleGraphics myTurtleGraphics;
  private TextArea myText;
  private int INITIAL_X = 0;
  private int INITIAL_Y = 0;


  public View(String language) {
    myLanguageResources = ResourceBundle.getBundle(Main.DEFAULT_RESOURCE_PACKAGE + "View" + language);
    myPanelResources = ResourceBundle.getBundle(Main.DEFAULT_RESOURCE_PACKAGE + PANEL_RESOURCES);
  }

  public void setController(Controller controller) {
    myController = controller;
    myTurtleGraphics = new TurtleGraphics(INITIAL_X, INITIAL_Y, DRAWER, myController);
  }

  /**
   * Purpose:
   * <p> Create a scene with all view components
   * Assumptions:
   * <p> None
   * Parameters:
   * <p> Width and height of scene
   * Exceptions:
   * <p> None
   * Return:
   * <p> Scene
   *
   * @author Woonggyu Jin, Charles Turpin
   */
  public Scene makeScene(int width, int height) {
    BorderPane root = new BorderPane();
    root.getStyleClass().add("grid-pane");
    root.setId("Pane");
    root.setBottom(makeInputPanel());

    HBox titleBox = new HBox();
    makeSimTitle(titleBox);
    makeOptions(titleBox, getPanelButtons("Options"));
    root.setTop(titleBox);

    root.setCenter(myTurtleGraphics.setCanvas());
    root.getChildren().add(myTurtleGraphics.setTurtle());

    VBox animControlPanel = new VBox();
    makeAnimationButtons(animControlPanel, getPanelButtons("AnimationControl"));
    root.setLeft(animControlPanel);

    ScrollPane commandHistory = new ScrollPane();
    commandHistory.setId("ScrollPane");
    myText = new TextArea();
    myText.setId("TextArea");
    makeCommandHistory(commandHistory);
    root.setRight(commandHistory);

    Scene scene = new Scene(root, width, height);
    // activate CSS styling
    scene.getStylesheets().add(getClass().getResource(DEFAULT_STYLESHEET).toExternalForm());
    return scene;
  }

  /**
   * Purpose:
   * <p> Get the TurtleGraphic associated with the view
   * Assumptions:
   * <p> None
   * Parameters:
   * <p> None
   * Exceptions:
   * <p> None
   * Return:
   * <p> TurtleGraphic
   *
   * @author Woonggyu Jin
   */
  public TurtleGraphics getTurtleGraphic() {
    return myTurtleGraphics;
  }

  private void makeSimTitle(HBox result) {
    //title should come from properties file
    Text simTitle = new Text(myLanguageResources.getString("SimulationTitle"));
    simTitle.setId("SimulationTitle");
    result.getChildren().add(simTitle);

    //return result;
  }

  private void makeOptions(HBox result, List<String> actions) {
    //add a GridPane with each button, 2 per row
    FlowPane buttonLayout = new FlowPane();
    for (String a : actions) {
      buttonLayout.getChildren().add(makeButton(a));
    }
    result.getChildren().add(buttonLayout);
    //return result;
  }

  private Button makeButton(String property) {
    Button result = new Button();
    String label = myLanguageResources.getString(property);
    result.setText(label);
    result.setId(property);
    myController.setButtonMethod(result);
    return result;
  }

  /**
   * Purpose:
   * <p> Get names of buttons associated with a type of button from properties file
   * Assumptions:
   * <p> Used outside this class only for testing
   * Parameters:
   * <p> Property
   * Exceptions:
   * <p> None
   * Return:
   * <p> List
   *
   * @author Woonggyu Jin
   */
  public List<String> getPanelButtons(String property) {
    return Arrays.asList(myPanelResources.getString(property).split(","));
  }

  private void makeAnimationButtons(VBox result, List<String> actions) {
    for (String a : actions) {
      if (a.contains("Color")) {
        result.getChildren().add(makeColorPicker(a));
      } else {
        result.getChildren().add(makeButton(a));
      }
    }
  }

  private ColorPicker makeColorPicker(String property) {
    ColorPicker colorPicker = new ColorPicker();
    colorPicker.setValue(Color.BLACK);
    colorPicker.setId(property);
    myController.setColorMethod(colorPicker);
    return colorPicker;
  }

  private void makeCommandHistory(ScrollPane result) {
    result.setPrefSize(myController.getDimensions(result.getId()).getWidth(),
            myController.getDimensions(result.getId()).getHeight());
    myText.setPrefSize(myController.getDimensions(myText.getId()).getWidth(),
            myController.getDimensions(myText.getId()).getHeight());
    result.setContent(myText);
  }

  //this method can take in a list of buttons
  private Node makeInputPanel() {
    HBox result = new HBox();
    // create buttons, with their associated actions
    // add non-button component to panel

    myCommandDisplay = makeInputField("CommandInput");
    myController.setInputMethod(myCommandDisplay);
    result.setAlignment(Pos.CENTER);
    result.getChildren().add(myCommandDisplay);
    return result;
  }

  private TextField makeInputField(String property) {
    TextField result = new TextField();
    result.setText(myLanguageResources.getString(property));
    result.setId(property);
    result.setPrefWidth(myController.getDimensions(property).width);
    result.setPrefHeight(myController.getDimensions(property).height);
    return (TextField) setID(property, result);
  }

  private Node setID(String id, Node node) {
    node.setId(id);
    return node;
  }

  /**
   * Purpose:
   * <p> Get properties file that specifies text associated with language
   * Assumptions:
   * <p> Used outside this class only for testing
   * Parameters:
   * <p> None
   * Exceptions:
   * <p> None
   * Return:
   * <p> ResourceBundle
   *
   * @author Woonggyu Jin
   */
  public ResourceBundle getMyLanguageResources() {
    return myLanguageResources;
  }

  /**
   * Purpose:
   * <p> Used by the controller to generate a popup in the scene.
   * Assumptions:
   * <p> None
   * Parameters:
   * <p> Stage
   * Exceptions:
   * <p> Popup keeps asking to provide valid input if none are given.
   * Return:
   * <p> None
   *
   * @author Woonggyu Jin
   */
  public CompletableFuture<Integer> generateInputPopup(Stage stage) {
    // create a layout for the popup
    VBox layout = new VBox();
    layout.setAlignment(Pos.CENTER);
    Label prompt = new Label("Enter a number:");
    TextField inputField = new TextField();
    inputField.setId("Input");
    Button submitButton = new Button("Submit");
    layout.getChildren().addAll(prompt, inputField, submitButton);
    Stage popupStage = new Stage();
    popupStage.initModality(Modality.WINDOW_MODAL);
    popupStage.initOwner(stage);
    popupStage.setTitle(null);
    popupStage.setScene(new Scene(layout, myController.getDimensions("InputPopup").width,
            myController.getDimensions("InputPopup").height));
    CompletableFuture<Integer> futureInput = new CompletableFuture<>();
    submitButton.setOnAction(e -> {
      String input = inputField.getText();
      try {
        int value = Integer.parseInt(input);
        popupStage.close();
        futureInput.complete(value);
      } catch (NumberFormatException ex) {
        // display an error message and keep the popup open
        prompt.setText("Invalid input. Please enter an integer:");
        inputField.setText("");
      }
    });
    popupStage.showAndWait();
    return futureInput.thenComposeAsync(input -> {
      if (input != null) {
        return CompletableFuture.completedFuture(input);
      } else {
        return generateInputPopup(stage);
      }
    });
  }

  /**
   * Purpose:
   * <p> Get text area that stores command history
   * Assumptions:
   * <p> None
   * Parameters:
   * <p> None
   * Exceptions:
   * <p> None
   * Return:
   * <p> TextArea
   *
   * @author Woonggyu Jin
   */
  public TextArea getMyText() {
    return myText;
  }
}


