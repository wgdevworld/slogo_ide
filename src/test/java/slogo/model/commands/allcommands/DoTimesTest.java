//package slogo.model.commands.allcommands;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import slogo.controller.TurtleObserver;
//import slogo.model.Turtle;
//
//class DoTimesTest {
//
//  private DoTimes doTimes;
//  private Turtle turtle;
//
//  @BeforeEach
//  void setUp() {
//    doTimes = new DoTimes();
//    turtle = new Turtle();
//  }
//
//  @Test
//  void testGetPops() {
//    assertEquals(2, doTimes.getPops());
//  }
//
//  @Test
//  void testSetBehavior() {
//    Stack<List<String>> ctrlLists = new Stack<>();
//    ArrayList<Double> paramList = new ArrayList<>();
//    List<TurtleObserver> observers = new ArrayList<>();
//    assertEquals(0, doTimes.setBehavior(paramList, turtle));
//  }
//
//  @Test
//  void testExecute() {
//    ArrayList<Double> paramList = new ArrayList<>();
//    assertEquals(0, doTimes.execute(turtle));
//  }
//}