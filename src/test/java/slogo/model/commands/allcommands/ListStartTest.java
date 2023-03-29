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

class ListStartTest {

  private ListStart listStart;
  private Turtle turtle;
  private Stack<ArrayList<String>> listStack;
  private InputParser parser;

  @BeforeEach
  void setUp() {
    listStart = new ListStart();
    turtle = new Turtle();
    parser = new InputParser();
    listStack = new Stack<>();
  }

  @ParameterizedTest
  @CsvSource({"10,25"})
  void testSetBehavior(double numA, double numB) {
    ArrayList<Double> paramList = new ArrayList<>();
    assertEquals(0,  listStart.setBehavior(paramList, turtle, listStack, parser.getObservers()));
  }

  @Test
  void testExecute() {
    assertEquals(0, listStart.execute(turtle));
  }
}