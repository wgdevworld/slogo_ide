package slogo.model.commands.allcommands;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import slogo.model.Turtle;
import slogo.model.parsers.InputParser;

class SetHeadingTest {

  private SetHeading seth;
  private Turtle turtle;
  private Stack<ArrayList<String>> listStack;
  private InputParser parser;

  @BeforeEach
  void setUp() {
    seth = new SetHeading();
    turtle = new Turtle();
    parser = new InputParser();
    listStack = new Stack<>();
  }

  @ParameterizedTest
  @CsvSource({"90", "180", "-270"})
  void testSetBehavior(double degrees) {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(degrees);
    double num = seth.setBehavior(paramList, turtle, listStack, parser.getObservers());
    assertEquals(degrees, num);

  }

  @ParameterizedTest
  @CsvSource({"90", "45", "180"})
  void testExecute(double degrees) {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(degrees);
    seth.setBehavior(paramList, turtle, listStack, parser.getObservers());
    double prevDirection = turtle.getDirection();
    assertEquals(Math.min(Math.abs(prevDirection - degrees), 360 - Math.abs(prevDirection - degrees)), seth.execute(turtle));
  }
}