package slogo.model.commands.allcommands;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.Turtle;
import slogo.model.parsers.InputParser;

class ForwardTest {

  private Forward fwd;
  private Turtle turtle;
  private Stack<ArrayList<String>> listStack;
  private InputParser parser;

  @BeforeEach
  void setUp() {
    fwd = new Forward();
    turtle = new Turtle();
    parser = new InputParser();
    listStack = new Stack<>();
  }

  @Test
  void testSetBehavior() {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(50.0);
    assertEquals(50, fwd.setBehavior(paramList, turtle, listStack, parser.getObservers()));

  }

  @Test
  void testExecute() {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(-125.0);
    fwd.setBehavior(paramList, turtle, listStack, parser.getObservers());
    assertEquals(125, fwd.execute(turtle));
  }
}