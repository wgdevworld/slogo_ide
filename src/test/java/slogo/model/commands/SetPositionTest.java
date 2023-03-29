package slogo.model.commands;


import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.Turtle;
import slogo.model.commands.allcommands.SetPosition;

import static org.junit.jupiter.api.Assertions.*;

public class SetPositionTest {

  private Commands y10;
  private Commands x10;
  private Commands x10y10;

  @BeforeEach
  void setUp () {
    y10 = new SetPosition(Arrays.asList("0", "10"));
    x10 = new SetPosition(Arrays.asList("10", "0"));
    x10y10 = new SetPosition(Arrays.asList("10", "10"));
  }

  @Test
  void testExecute () {
    assertEquals(10, y10.execute(new Turtle()));
    assertFalse(10 != x10.execute(new Turtle()));
    assertEquals(14.14213562, x10y10.execute(new Turtle()), 0.000001);
  }
}
