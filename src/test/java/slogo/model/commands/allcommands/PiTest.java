package slogo.model.commands.allcommands;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.Turtle;
import slogo.model.parsers.InputParser;

class PiTest {

  private Pi pi;
  private Turtle turtle;
  private Stack<ArrayList<String>> listStack;
  private InputParser parser;

  @BeforeEach
  void setUp() {
    pi = new Pi();
    turtle = new Turtle();
    parser = new InputParser();
    listStack = new Stack<>();
  }


  @Test
  void testSetBehavior() {
    ArrayList<Double> paramList = new ArrayList<>();
    assertEquals(Math.PI, pi.setBehavior(paramList, turtle, listStack, parser.getObservers()) );
  }

  @Test
  void testExecute() {
    assertEquals(Math.PI, pi.execute(turtle));
  }
}