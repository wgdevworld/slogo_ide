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

class SetPositionTest {

  private SetPosition setxy;
  private Turtle turtle;
  private Stack<ArrayList<String>> listStack;
  private InputParser parser;

  @BeforeEach
  void setUp() {
    setxy = new SetPosition();
    turtle = new Turtle();
    parser = new InputParser();
    listStack = new Stack<>();
  }

  @ParameterizedTest
  @CsvSource({"25,50", "0,200", "-50,-25"})
  void testSetBehavior(double x, double y ) {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(x);
    paramList.add(y);
    assertEquals(1, setxy.setBehavior(paramList, turtle, listStack, parser.getObservers()));

  }

  @Test
  void testExecute() {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(50.0);
    paramList.add(100.0);
    setxy.setBehavior(paramList, turtle, listStack, parser.getObservers());
    double distance = Math.hypot(turtle.getX() - 50, turtle.getY() - 100);
    assertEquals(Math.abs(distance), setxy.execute(turtle));
    assertEquals(50, turtle.getX());
    assertEquals(-100, turtle.getY());
  }
}