package slogo.model.commands.allcommands;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import slogo.model.Turtle;
import slogo.model.parsers.InputParser;

class TangentTest {

  private Tangent cos;
  private Turtle turtle;
  private Stack<ArrayList<String>> listStack;
  private InputParser parser;

  @BeforeEach
  void setUp() {
    cos = new Tangent();
    turtle = new Turtle();
    parser = new InputParser();
    listStack = new Stack<>();
  }

  @ParameterizedTest
  @CsvSource({"30", "90", "45"})
  void testSetBehavior(double degrees) {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(degrees);
    assertEquals(Math.tan((degrees * Math.PI / 180)), cos.setBehavior(paramList, turtle, listStack, parser.getObservers()));
  }

  @ParameterizedTest
  @CsvSource({"-30", "540", "0"})
  void testExecute(double degrees) {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(degrees);
    cos.setBehavior(paramList, turtle, listStack, parser.getObservers());
    assertEquals(Math.tan(degrees * Math.PI / 180), cos.execute(turtle));
  }
}