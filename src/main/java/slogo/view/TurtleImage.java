package slogo.view;

import java.awt.Dimension;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import slogo.Main;

public class TurtleImage extends ImageView {

  private static final String IMAGE_RESOURCES = "Image";
  private static final String IMAGE_TYPE = "Turtle";
  private static final String DIMENSION_RESOURCES = "Dimensions";
  //these magic numbers are to offset the position of the turtle and are JavaFX peculiarities
  private static final int MAGIC_XOFFSET = 35;
  private static final int MAGIC_YOFFSET = 2;
  private static final int DEFAULT_DIRECTION = 90;


  private static double xOffset;
  private static double yOffset;
  private static ResourceBundle myImageResources;
  private static ResourceBundle myDimensionResources;

  public TurtleImage() {
    myImageResources = ResourceBundle.getBundle(Main.DEFAULT_RESOURCE_PACKAGE + IMAGE_RESOURCES);
    myDimensionResources = ResourceBundle.getBundle(
        Main.DEFAULT_RESOURCE_PACKAGE + DIMENSION_RESOURCES);
    this.setImage(new Image(this.getClass().getClassLoader().getResourceAsStream(
        Main.DEFAULT_RESOURCE_PACKAGE + myImageResources.getString(IMAGE_TYPE))));
    this.setFitWidth(getDimensions(IMAGE_TYPE).width);
    this.setFitHeight(getDimensions(IMAGE_TYPE).height);
    xOffset = getDimensions("Stage").width / 2 - this.getFitWidth() / 2 - MAGIC_XOFFSET;
    yOffset = getDimensions("Stage").height / 2 - this.getFitHeight() / 2 - MAGIC_YOFFSET;
    this.setRotate(DEFAULT_DIRECTION);
  }

  public void home() {
    this.setX(xOffset);
    this.setY(yOffset);
    this.setRotate(90);
  }

  //TODO: refactor to remove duplicate code in controller
  private Dimension getDimensions(String property) {
    List<String> dimensionList = Arrays.asList(myDimensionResources.getString(property).split(","));
    return new Dimension(Integer.parseInt(dimensionList.get(0)),
        Integer.parseInt(dimensionList.get(1)));
  }

  public void move(double x, double y) {
    this.setX(x + xOffset);
    this.setY(y + yOffset);
  }

  public void hide() {
    this.setOpacity(0);
  }

  public void show() {
    this.setOpacity(100);
  }

  public void rotate(double degrees) {
    this.setRotate(DEFAULT_DIRECTION + degrees);
  }

}
