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

class GreaterThanTest {

  private GreaterThan greaterThan;
  private Turtle turtle;
  private Stack<ArrayList<String>> listStack;
  private InputParser parser;

  @BeforeEach
  void setUp() {
    greaterThan = new GreaterThan();
    turtle = new Turtle();
    parser = new InputParser();
    listStack = new Stack<>();
  }

  @ParameterizedTest
  @CsvSource({"50,25"})
  void testSetBehavior(double numA, double numB) {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(numA);
    paramList.add(numB);
    double eval = greaterThan.setBehavior(paramList, turtle, listStack, parser.getObservers());
    assertEquals(1, eval);
  }

  @Test
  void testExecute() {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(0.0);
    paramList.add(100.0);
    greaterThan.setBehavior(paramList, turtle, listStack, parser.getObservers());
    assertEquals(0, greaterThan.execute(turtle));
  }
}