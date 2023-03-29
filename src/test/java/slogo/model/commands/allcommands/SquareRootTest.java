package slogo.model.commands.allcommands;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import slogo.model.Turtle;
import slogo.model.parsers.InputParser;

class SquareRootTest {

  private SquareRoot sqrt;
  private Turtle turtle;
  private Stack<ArrayList<String>> listStack;
  private InputParser parser;

  @BeforeEach
  void setUp() {
    sqrt = new SquareRoot();
    turtle = new Turtle();
    parser = new InputParser();
    listStack = new Stack<>();
  }

  @ParameterizedTest
  @CsvSource({"4", "12", "118"})
  void testSetBehavior(double expr) {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(expr);
    assertEquals(Math.sqrt(expr), sqrt.setBehavior(paramList, turtle, listStack, parser.getObservers()));
  }

  @ParameterizedTest
  @CsvSource({"-30", "540", "0"})
  void testExecute(double expr) {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(expr);
    sqrt.setBehavior(paramList, turtle, listStack, parser.getObservers());
    assertEquals(Math.sqrt(expr), sqrt.execute(turtle));
  }
}