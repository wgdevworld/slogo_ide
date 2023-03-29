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

class RandomRangeTest {

  private RandomRange randr;
  private Turtle turtle;
  private Stack<ArrayList<String>> listStack;
  private InputParser parser;

  @BeforeEach
  void setUp() {
    randr = new RandomRange();
    turtle = new Turtle();
    parser = new InputParser();
    listStack = new Stack<>();
  }

  @ParameterizedTest
  @CsvSource({"25,50", "10,20", "50,75"})
  void testSetBehavior(double min, double max ) {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(min);
    paramList.add(max);
    double num = randr.setBehavior(paramList, turtle, listStack, parser.getObservers());
    assertTrue(min < num && num < max);

  }

  @Test
  void testExecute() {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(50.0);
    paramList.add(100.0);
    randr.setBehavior(paramList, turtle, listStack, parser.getObservers());
    assertTrue(50.0 < randr.execute(turtle) && randr.execute(turtle) < 100);
  }
}