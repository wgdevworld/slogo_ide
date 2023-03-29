//package slogo.model.commands.allcommands;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.ArrayList;
//import java.util.Stack;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import slogo.model.Turtle;
//import slogo.model.commands.Commands;
//
//class ConditionalTest {
//
//  private Conditional cond;
//  private Turtle turtle;
//  private LessThan lt;
//  private Forward fwd;
//  private Backward bck;
//  private ListStart start;
//  private ListEnd end;
//  private Stack<Commands> commandStack;
//
//  @BeforeEach
//  void setUp() {
//    cond = new Conditional();
//    turtle = new Turtle();
//    ArrayList<Double> params = new ArrayList<>();
//    params.add(40.0);
//    params.add(50.0);
//    commandStack = new Stack<>();
//    lt = new LessThan();
//    fwd = new Forward();
//    bck = new Backward();
//    start = new ListStart();
//    end = new ListEnd();
//    lt.setBehavior(params, turtle);
//    fwd.setBehavior(params, turtle);
//    bck.setBehavior(params, turtle);
//    start.setBehavior(params, turtle);
//    end.setBehavior(params, turtle);
//    Commands[] commandsArray = {end, fwd, start, end, bck, start};
//    for (Commands cmd : commandsArray) {
//      commandStack.push(cmd);
//    }
//  }
//
//  @Test
//  void testSetBehavior() {
//    ArrayList<Double> paramList = new ArrayList<>();
//    assertEquals(0, cond.setBehavior(paramList, turtle));
//  }
//
//  @Test
//  void testSetConditions() {
//    assertTrue(cond.setConditions(commandStack).isEmpty());
//  }
//
//  @Test
//  void testExecute() {
//    cond.evaluateBoolean(lt, turtle);
//    cond.setConditions(commandStack);
//    assertEquals(40, cond.execute(turtle));
//  }
//}