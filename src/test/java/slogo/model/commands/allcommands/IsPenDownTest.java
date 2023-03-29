package slogo.model.commands.allcommands;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.Turtle;
import slogo.model.parsers.InputParser;

class IsPenDownTest {

  private IsPenDown penD;
  private Turtle turtle;
  private Stack<ArrayList<String>> listStack;
  private InputParser parser;

  @BeforeEach
  void setUp() {
    penD = new IsPenDown();
    turtle = new Turtle();
    parser = new InputParser();
    listStack = new Stack<>();
  }

  @Test
  void testSetBehavior() {
    ArrayList<Double> paramList = new ArrayList<>();
    assertEquals(1, penD.setBehavior(paramList, turtle, listStack, parser.getObservers()));
    turtle.setPenDown(false);
    assertEquals(0, penD.setBehavior(paramList, turtle, listStack, parser.getObservers()));
  }

  @Test
  void testExecute() {
      assertEquals(1, penD.execute(turtle));
      turtle.setPenDown(false);
      assertFalse(turtle.isPenDown());
      turtle.setPenDown(!turtle.isPenDown());
      assertTrue(turtle.isPenDown());
  }
}