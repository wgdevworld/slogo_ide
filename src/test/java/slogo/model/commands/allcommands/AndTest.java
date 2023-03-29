package slogo.model.commands.allcommands;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.Turtle;
import slogo.model.parsers.InputParser;

class AndTest {

  private And and;
  private Turtle turtle;
  private Stack<ArrayList<String>> listStack;
  private InputParser parser;

  @BeforeEach
  void setUp() {
    and = new And();
    turtle = new Turtle();
    parser = new InputParser();
    listStack = new Stack<>();
  }

  // paramList, turtle, listStack, parser.getObservers()

  @Test
  void testSetBehavior() {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(1.0);
    paramList.add(1.0);
    assertEquals(1, and.setBehavior(paramList, turtle, listStack, parser.getObservers()));
    paramList.set(1, 0.0);
    assertEquals(0,and.setBehavior(paramList, turtle, listStack, parser.getObservers()));
  }

  @Test
  void testExecute() {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(1.0);
    paramList.add(1.0);
    and.setBehavior(paramList, turtle, listStack, parser.getObservers());
    assertEquals(1,and.execute(turtle));
    paramList.set(1, 0.0);
    and.setBehavior(paramList, turtle, listStack, parser.getObservers());
    assertEquals(0,and.execute(turtle));
  }
}