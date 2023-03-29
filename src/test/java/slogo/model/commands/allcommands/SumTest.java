package slogo.model.commands.allcommands;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.Turtle;
import slogo.model.parsers.InputParser;

class SumTest {

  private Sum sum;
  private Turtle turtle;
  private Stack<ArrayList<String>> listStack;
  private InputParser parser;

  @BeforeEach
  void setUp() {
    sum = new Sum();
    turtle = new Turtle();
    parser = new InputParser();
    listStack = new Stack<>();
  }

  @Test
  void testSetBehavior() {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(50.0);
    paramList.add(25.0);
    assertEquals(75, sum.setBehavior(paramList, turtle, listStack, parser.getObservers()));

  }

  @Test
  void testExecute() {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(50.0);
    paramList.add(-100.0);
    sum.setBehavior(paramList, turtle, listStack, parser.getObservers());
    assertEquals(-50, sum.execute(turtle));
  }
}