package slogo.model.commands.allcommands;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.Turtle;
import slogo.model.parsers.InputParser;

class ConstantTest {

  private Constant constant;
  private Turtle turtle;
  private Stack<ArrayList<String>> listStack;
  private InputParser parser;


  @BeforeEach
  void setUp() {
    constant = new Constant();
    turtle = new Turtle();
    parser = new InputParser();
    listStack = new Stack<>();
  }

  @Test
  void testSetBehavior() {
    ArrayList<Double> paramList = new ArrayList<>();
    constant.set(50.0);
    assertEquals(50, constant.setBehavior(paramList, turtle, listStack, parser.getObservers()));

  }

  @Test
  void testExecute() {
    constant.set(100.0);
    assertEquals(100, constant.execute(turtle));
  }
}