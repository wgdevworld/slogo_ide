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

class HomeTest {

  private Home home;
  private Turtle turtle;
  private Stack<ArrayList<String>> listStack;
  private InputParser parser;

  @BeforeEach
  void setUp() {
    home = new Home();
    turtle = new Turtle();
    parser = new InputParser();
    listStack = new Stack<>();
  }

  @Test
  void testSetBehavior() {
    ArrayList<Double> paramList = new ArrayList<>();
    assertEquals(1, home.setBehavior(paramList, turtle, listStack, parser.getObservers()));

  }

  @ParameterizedTest
  @CsvSource({"50,25","0,0","100,65"})
  void testExecute(double x, double y) {
    turtle.setPosition(x, y);
    double distance = Math.hypot(x - 0, y - 0);
    assertEquals(distance, home.execute(turtle));
    assertEquals(0, turtle.getDirection());
    assertEquals(0, turtle.getX());
    assertEquals(0, turtle.getY());
  }
}