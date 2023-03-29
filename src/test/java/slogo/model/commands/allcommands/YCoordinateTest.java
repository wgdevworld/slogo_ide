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

class YCoordinateTest {

  private YCoordinate ycoor;
  private Turtle turtle;
  private Stack<ArrayList<String>> listStack;
  private InputParser parser;

  @BeforeEach
  void setUp() {
    ycoor = new YCoordinate();
    turtle = new Turtle();
    parser = new InputParser();
    listStack = new Stack<>();
  }

  @Test
  void testSetBehavior() {
    ArrayList<Double> paramList = new ArrayList<>();
    assertEquals(turtle.getY(), ycoor.setBehavior(paramList, turtle, listStack, parser.getObservers()));
  }

  @ParameterizedTest
  @CsvSource({"30", "20", "-70", "870"})
  void testExecute(double coord) {
    ArrayList<Double> paramList = new ArrayList<>();
    turtle.setY(coord);
    assertEquals(turtle.getY(), ycoor.execute(turtle));
  }
}