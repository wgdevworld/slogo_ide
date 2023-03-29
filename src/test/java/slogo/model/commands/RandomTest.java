package slogo.model.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.Turtle;
import slogo.model.commands.allcommands.RandomRange;

import static org.junit.jupiter.api.Assertions.*;

public class RandomTest {
  private Commands randomizer10;
  private Commands randomizer20;
  private Commands randomizer100;

  @BeforeEach
  void setUp () {
    randomizer10 = new RandomRange(List.of("10"));
    randomizer20 = new RandomRange(List.of("20"));
    randomizer100 = new RandomRange(List.of("100"));
  }

  @Test
  void testExecute () {
    assertTrue(randomizer10.execute(new Turtle()) < 10);
    assertTrue(randomizer20.execute(new Turtle()) < 20);
    assertTrue(randomizer100.execute(new Turtle()) < 100);
  }
}
