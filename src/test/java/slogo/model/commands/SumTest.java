package slogo.model.commands;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.Turtle;
import slogo.model.commands.allcommands.Sum;

import static org.junit.jupiter.api.Assertions.*;

public class SumTest {
  private Commands sum20;
  private Commands sumNeg;
  private Commands sum12;
  private final List<String> PARAMS1 = List.of("15", "5");
  private final List<String> PARAMS2 = List.of("-25", "7");
  private final List<String> PARAMS3 = List.of("6", "6");



  @BeforeEach
  void setUp () {
    sum20 = new Sum(PARAMS1);
    sumNeg = new Sum(PARAMS2);
    sum12 = new Sum(PARAMS3);
  }

  @Test
  void testExecute () {
    assertEquals(20, sum20.execute(new Turtle()));
    assertTrue(sumNeg.execute(new Turtle()) < 0);
    assertEquals(12, sum12.execute(new Turtle()));
  }
}
