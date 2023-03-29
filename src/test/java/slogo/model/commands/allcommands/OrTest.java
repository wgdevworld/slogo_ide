package slogo.model.commands.allcommands;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.Turtle;
import slogo.model.parsers.InputParser;

class OrTest {

  private Or or;
  private Turtle turtle;
  private Stack<ArrayList<String>> listStack;
  private InputParser parser;

  @BeforeEach
  void setUp() {
    or = new Or();
    turtle = new Turtle();
    parser = new InputParser();
    listStack = new Stack<>();
  }


  @Test
  void testSetBehavior() {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(1.0);
    paramList.add(1.0);
    assertEquals(1, or.setBehavior(paramList, turtle, listStack, parser.getObservers()) );
    paramList.set(1, 0.0);
    assertEquals(1, or.setBehavior(paramList, turtle, listStack, parser.getObservers()) );
  }

  @Test
  void testExecute() {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(0.0);
    paramList.add(0.0);
    or.setBehavior(paramList, turtle, listStack, parser.getObservers());
    assertEquals(0, or.execute(turtle));
    paramList.set(1, 1.0);
    or.setBehavior(paramList, turtle, listStack, parser.getObservers());
    assertEquals(1, or.execute(turtle));
  }
}