package slogo.view;

import static org.testfx.assertions.api.Assertions.assertThat;

import java.awt.Dimension;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.matcher.control.TextInputControlMatchers;
import org.testfx.matcher.control.TextMatchers;
import slogo.controller.Controller;

class ViewTest extends ApplicationTest {
  private static final String language = "English";
  private static Dimension TEST_DIMENSIONS = new Dimension(1000, 700);
  private Controller myController;
  private View myView;


  @Override
  public void start (Stage stage) {
    myController = new Controller(language, stage);
    myView = myController.getMyView();
    stage.setScene(myView.makeScene(TEST_DIMENSIONS.width, TEST_DIMENSIONS.height));
    stage.show();
  }
  @Test
  public void testSimTitleText() {
    Text simTitle = lookup("#SimulationTitle").query();
    FxAssert.verifyThat(simTitle, Text::isVisible);
    String expectedTitle = "Simple SLogo";
    FxAssert.verifyThat(simTitle, TextMatchers.hasText(expectedTitle));
  }
  @Test
  public void testMakeOptions() {
    for (String buttonId : myController.getMyView().getPanelButtons("Options")) {
      Button b = lookup("#" + buttonId).query();
      String expectedText = myController.getMyView().getMyLanguageResources().getString(buttonId);
      FxAssert.verifyThat(b, LabeledMatchers.hasText(expectedText));
    }
  }

  @Test
  public void testMakeAnimationButtons() {
    for (String buttonId : myController.getMyView().getPanelButtons("AnimationControl")) {
      if (!buttonId.contains("Color")) {
        Button b = lookup("#" + buttonId).query();
        String expectedText = myController.getMyView().getMyLanguageResources().getString(buttonId);
        FxAssert.verifyThat(b, LabeledMatchers.hasText(expectedText));
      }
    }
  }

  @Test
  public void testMakeInputPanel() {
    TextField commandTextField = lookup("#CommandInput").query();
    String expectedText = "Enter command and press enter";
    FxAssert.verifyThat(commandTextField, TextInputControlMatchers.hasText(expectedText));
  }

  @Test
  public void testMakeColorPicker() {
    ColorPicker colorPicker = lookup("#ColorCommand").query();
    Color expectedColor = Color.BLACK;
    assertThat(colorPicker.getValue().equals(expectedColor));
  }

  @Test
  public void testGenerateInputPopup() {
    Button button = lookup("#ForwardCommand").queryButton();
    clickOn(button);
    TextField textField = lookup("#Input").query();
    String mockInput = "30";
    write(mockInput);
    assertThat(textField.getText()).isEqualTo(mockInput);
  }
}