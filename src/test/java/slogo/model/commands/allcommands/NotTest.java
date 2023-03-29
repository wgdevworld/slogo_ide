package slogo.model.commands.allcommands;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.Turtle;
import slogo.model.parsers.InputParser;

class NotTest {

  private Not not;
  private Turtle turtle;
  private Stack<ArrayList<String>> listStack;
  private InputParser parser;

  @BeforeEach
  void setUp() {
    not = new Not();
    turtle = new Turtle();
    parser = new InputParser();
    listStack = new Stack<>();
  }


  @Test
  void testSetBehavior() {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(1.0);
    assertEquals(0,not.setBehavior(paramList, turtle, listStack, parser.getObservers()) );
    paramList.set(0, 0.0);
    assertEquals(1,not.setBehavior(paramList, turtle, listStack, parser.getObservers()) );
  }

  @Test
  void testExecute() {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(1.0);
    not.setBehavior(paramList, turtle, listStack, parser.getObservers());
    assertEquals(0,not.execute(turtle));
    paramList.set(0, 0.0);
    not.setBehavior(paramList, turtle, listStack, parser.getObservers());
    assertEquals(1,not.execute(turtle));
  }
}