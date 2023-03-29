package slogo.model.commands.allcommands;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.Turtle;
import slogo.model.parsers.InputParser;

class DifferenceTest {

  private Difference diff;
  private Turtle turtle;
  private Stack<ArrayList<String>> listStack;
  private InputParser parser;

  @BeforeEach
  void setUp() {
    diff = new Difference();
    turtle = new Turtle();
    parser = new InputParser();
    listStack = new Stack<>();
  }

  @Test
  void testSetBehavior() {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(50.0);
    paramList.add(25.0);
    assertEquals(25, diff.setBehavior(paramList, turtle, listStack, parser.getObservers()));

  }

  @Test
  void testExecute() {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(50.0);
    paramList.add(100.0);
    diff.setBehavior(paramList, turtle, listStack, parser.getObservers());
    assertEquals(-50, diff.execute(turtle));
  }
}