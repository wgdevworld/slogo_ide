package slogo.model.commands.allcommands;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import slogo.model.Turtle;
import slogo.model.parsers.InputParser;

class SetTowardsTest {

  private SetTowards towards;
  private Turtle turtle;
  private Stack<ArrayList<String>> listStack;
  private InputParser parser;

  @BeforeEach
  void setUp() {
    towards = new SetTowards();
    turtle = new Turtle();
    parser = new InputParser();
    listStack = new Stack<>();
  }

  @ParameterizedTest
  @CsvSource({"90,100", "180,0", "-270,-45"})
  void testSetBehavior(double x, double y) {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(x);
    paramList.add(y);
    double num = towards.setBehavior(paramList, turtle, listStack, parser.getObservers());
    assertEquals(1, num);

  }

  @ParameterizedTest
  @CsvSource({"-45,20", "80,55", "70,56"})
  void testExecute(double x, double y) {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(x);
    paramList.add(y);
    towards.setBehavior( paramList, turtle, listStack, parser.getObservers());
    double degrees = Math.toDegrees(Math.atan2(-1 * y - turtle.getY(), x - turtle.getX()));
    assertEquals(Math.abs(degrees), towards.execute(turtle));
    double finalDegrees = (degrees % 360 < 0) ? degrees + 360 : degrees % 360;
    assertEquals(finalDegrees, turtle.getDirection());
  }
}