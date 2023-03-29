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

class LessThanTest {

  private LessThan lessThan;
  private Turtle turtle;
  private Stack<ArrayList<String>> listStack;
  private InputParser parser;

  @BeforeEach
  void setUp() {
    lessThan = new LessThan();
    turtle = new Turtle();
    parser = new InputParser();
    listStack = new Stack<>();
  }

  @ParameterizedTest
  @CsvSource({"10,25"})
  void testSetBehavior(double numA, double numB) {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(numA);
    paramList.add(numB);
    double eval = lessThan.setBehavior(paramList, turtle, listStack, parser.getObservers());
    assertEquals(1, eval);
  }

  @Test
  void testExecute() {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(100.0);
    paramList.add(1.0);
    lessThan.setBehavior(paramList, turtle, listStack, parser.getObservers());
    assertEquals(0, lessThan.execute(turtle));
  }
}