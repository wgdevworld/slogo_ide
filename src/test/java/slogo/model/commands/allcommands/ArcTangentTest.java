package slogo.model.commands.allcommands;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.Turtle;
import slogo.model.parsers.InputParser;

class ArcTangentTest {

  private ArcTangent atan;
  private Turtle turtle;
  private Stack<ArrayList<String>> listStack;
  private InputParser parser;

  @BeforeEach
  void setUp() {
    atan = new ArcTangent();
    turtle = new Turtle();
    parser = new InputParser();
    listStack = new Stack<>();
  }


  @Test
  void testSetBehavior() {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(90.0);
    assertEquals(Math.atan((90 * Math.PI / 180)),atan.setBehavior(paramList, turtle, listStack, parser.getObservers()));
    paramList.set(0, 540.0);
    assertEquals(Math.atan((540 * Math.PI / 180)),atan.setBehavior(paramList, turtle, listStack, parser.getObservers()));
  }

  @Test
  void testExecute() {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(-270.0);
    atan.setBehavior(paramList, turtle, listStack, parser.getObservers());
    assertEquals(Math.atan((-270 * Math.PI / 180)),atan.execute(turtle));
    paramList.set(0, 180.0);
    atan.setBehavior(paramList, turtle, listStack, parser.getObservers());
    assertEquals(Math.atan((180 * Math.PI / 180)),atan.execute(turtle));
  }
}