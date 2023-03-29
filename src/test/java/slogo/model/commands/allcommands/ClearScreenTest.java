package slogo.model.commands.allcommands;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.Turtle;
import slogo.model.parsers.InputParser;

class ClearScreenTest {

  private ClearScreen clear;
  private Turtle turtle;
  private Stack<ArrayList<String>> listStack;
  private InputParser parser;


  @BeforeEach
  void setUp() {
    clear = new ClearScreen();
    turtle = new Turtle();
    turtle.setX(10);
    turtle.setY(20);
    parser = new InputParser();
    listStack = new Stack<>();
  }


  @Test
  void testSetBehavior() {
    ArrayList<Double> paramList = new ArrayList<>();
    assertEquals(1, clear.setBehavior(paramList, turtle, listStack, parser.getObservers()));

  }

  @Test
  void testExecute() {
    double distance = clear.execute(turtle);
    assertEquals(0, turtle.getX());
    assertEquals(0, turtle.getY());
    assertEquals(0, turtle.getDirection());
    assertEquals(22, Math.floor(distance));
  }
}