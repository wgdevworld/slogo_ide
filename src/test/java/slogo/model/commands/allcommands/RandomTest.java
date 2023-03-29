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

class RandomTest {

  private Random randr;
  private Turtle turtle;
  private Stack<ArrayList<String>> listStack;
  private InputParser parser;

  @BeforeEach
  void setUp() {
    randr = new Random();
    turtle = new Turtle();
    parser = new InputParser();
    listStack = new Stack<>();
  }

  @ParameterizedTest
  @CsvSource({"25", "10", "50"})
  void testSetBehavior( double max) {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(max);
    double num = randr.setBehavior(paramList, turtle, listStack, parser.getObservers());
    assertTrue(num < max);

  }

  @Test
  void testExecute() {
    ArrayList<Double> paramList = new ArrayList<>();
    paramList.add(50.0);
    randr.setBehavior(paramList, turtle, listStack, parser.getObservers());
    assertTrue(randr.execute(turtle) < 50);
  }
}