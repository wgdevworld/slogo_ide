package slogo.model.parsers;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.Turtle;
import java.util.Stack;
import slogo.model.commands.Commands;
import slogo.model.commands.allcommands.Backward;
import slogo.model.commands.allcommands.Forward;

import static org.junit.jupiter.api.Assertions.*;

public class InputParserTest {
  private InputParser parser;
  private Stack<Commands> commandStack;
  private Forward fwd;
  private Backward bk;

  @BeforeEach
  void setUp () {
    parser = new InputParser();
    ArrayList<Double> params = new ArrayList<>();
    Stack<ArrayList<String>> listStack = new Stack<>();
    params.add(40.0);
    params.add(50.0);
    fwd = new Forward();
    bk = new Backward();
    fwd.setBehavior(params, parser.getTurtle(), listStack, parser.getObservers());
    bk.setBehavior(params, parser.getTurtle(), listStack, parser.getObservers());
    commandStack = new Stack<>();
    Commands[] commandsArray = {bk, fwd};
    for (Commands cmd : commandsArray) {
      commandStack.push(cmd);
    }
  }

  @Test
  void testGetTurtle() {
    assertInstanceOf(Turtle.class, parser.getTurtle());
  }

  @Test
  void parseProgramCode() {

  }

  @Test
  void parseTokenizedInput() {

  }

  @Test
  void testParseCommandStack() throws Exception {
//    parser.parseProgramCode("fd bk 40");
//    Stack<Double> valStack = new Stack<>();
//    valStack.push(0.0);
//    valStack.push(40.0);
//    assertEquals(valStack, parser.parseCommandStack(commandStack));
  }

  @Test
  void getCommands() {

  }
  }

