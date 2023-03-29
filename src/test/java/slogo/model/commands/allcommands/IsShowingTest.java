package slogo.model.commands.allcommands;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import slogo.model.Turtle;
import slogo.model.parsers.InputParser;

class IsShowingTest {

  private IsShowing showing;
  private Turtle turtle;
  private Stack<ArrayList<String>> listStack;
  private InputParser parser;

  @BeforeEach
  void setUp() {
    showing = new IsShowing();
    turtle = new Turtle();
    parser = new InputParser();
    listStack = new Stack<>();
  }

  @Test
  void testSetBehavior() {
    ArrayList<Double> paramList = new ArrayList<>();
    assertEquals(1, showing.setBehavior(paramList, turtle, listStack, parser.getObservers()));
    turtle.setVisibility(false);
    assertEquals(0, showing.setBehavior(paramList, turtle, listStack, parser.getObservers()));
  }

  @Test
  void testExecute() {
    assertEquals(1, showing.execute(turtle));
    turtle.setVisibility(false);
    assertFalse(turtle.isVisible());
    turtle.setVisibility(!turtle.isVisible());
    assertTrue(turtle.isVisible());
  }
}