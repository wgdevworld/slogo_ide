package slogo.model.commands.allcommands;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.Turtle;
import slogo.model.parsers.InputParser;

class BackwardTest {

  private Backward back;
  private Turtle turtle;
  private Stack<ArrayList<String>> listStack;
  private InputParser parser;


  @BeforeEach
  void setUp() {
    back = new Backward();
    turtle = new Turtle();
    parser = new InputParser();
    listStack = new Stack<>();
  }


  @Test
  void testSetBehbackvior() {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(50.0);
    assertEquals(50, back.setBehavior(paramList, turtle, listStack, parser.getObservers()) );
    paramList.set(0, 100.0);
    assertEquals(100, back.setBehavior(paramList, turtle, listStack, parser.getObservers()));
    paramList.set(0, -200.0);
    assertTrue(back.setBehavior(paramList, turtle, listStack, parser.getObservers()) > 0);

  }

  @Test
  void testExecute() {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(25.0);
    back.setBehavior(paramList, turtle, listStack, parser.getObservers());
    assertEquals(25, back.execute(turtle));
    paramList.set(0, -180.0);
    back.setBehavior(paramList, turtle, listStack, parser.getObservers());
    assertTrue(back.execute(turtle) > 0);
  }
}