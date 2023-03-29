package slogo.model.commands.allcommands;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import slogo.model.Turtle;
import slogo.model.commands.VariableMap;
import slogo.model.parsers.InputParser;

class VariableTest {

  private Variable var;
  private Turtle turtle;
  private Stack<ArrayList<String>> listStack;
  private InputParser parser;


  @BeforeEach
  void setUp() {
    var = new Variable();
    turtle = new Turtle();
    parser = new InputParser();
    listStack = new Stack<>();
    VariableMap.variableMap.clear();
    VariableMap.variableMap.put("degree", 90.0);
    VariableMap.variableMap.put("sum", 200.0);
  }

  @ParameterizedTest
  @CsvSource({"random", "distance"})
  void testSetGetNameMethod(String name) {
    var.set(name);
    assertTrue(VariableMap.variableMap.containsKey(name));
    assertEquals(name, var.getName());
  }

  @ParameterizedTest
  @CsvSource({"50.0,degree", "0.0,sum"})
  void testSetGetValMethod(double val, String name) {
    var.set(name);
    var.setVal(val);
    assertEquals(val, VariableMap.variableMap.get(name));
    assertEquals(val, var.getVal());
  }

  @ParameterizedTest
  @CsvSource({"degree", "sum"})
  void testSetBehbackvior(String name) {
    var.set(name);
    ArrayList<Double> paramList = new ArrayList<>();
    assertEquals(VariableMap.variableMap.get(name), var.setBehavior(paramList, turtle, listStack, parser.getObservers()));
  }

  @ParameterizedTest
  @CsvSource({"50.0,degree", "0.0,sum"})
  void testExecute(double val, String name) {
    var.set(name);
    var.setVal(val);
    ArrayList<Double> paramList = new ArrayList<>();
    assertEquals(val, var.execute(turtle));
  }
}