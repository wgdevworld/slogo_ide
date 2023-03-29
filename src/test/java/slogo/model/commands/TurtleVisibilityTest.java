package slogo.model.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.Turtle;

import static org.junit.jupiter.api.Assertions.*;


public class TurtleVisibilityTest {

  private Commands show;
  private Commands hide;

  @BeforeEach
  void setUp () {
    show = new slogo.model.commands.allcommands.ShowTurtle();
    hide = new slogo.model.commands.allcommands.HideTurtle();

  }

  @Test
  void testExecute () {
    assertEquals(0, hide.execute(new Turtle()));
    assertEquals(1, show.execute(new Turtle()));
  }
}
