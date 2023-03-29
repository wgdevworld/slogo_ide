package slogo.model.parsers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InputParserTest {
  private InputParser parserTest;


  @BeforeEach
  void setUp () {
    parserTest = new InputParser();
  }

  @Test
  void testTokenizeLanguageCommand () {
    // try different case options
    assertEquals("Forward", parserTest.getSymbol("fd"));
    assertEquals("Forward", parserTest.getSymbol("FD"));
    assertEquals("Forward", parserTest.getSymbol("Fd"));
    assertEquals("Forward", parserTest.getSymbol("forward"));
    assertEquals("Forward", parserTest.getSymbol("Forward"));
    assertEquals("Forward", parserTest.getSymbol("ForwarD"));
    assertEquals("Forward", parserTest.getSymbol("FORWARD"));
    // spelling errors, or wrong language, are treated as a user defined command
    assertEquals("Command", parserTest.getSymbol("fdd"));
    assertEquals("Command", parserTest.getSymbol("ava"));
  }

  @Test
  void testTokenizeSyntax () {
    // try different decimal placements, positive and negative
    // note, must have a digit before decimal point
    assertEquals("Constant", parserTest.getSymbol("100"));
    assertEquals("Constant", parserTest.getSymbol("-100"));
    assertEquals("Constant", parserTest.getSymbol("100."));
    assertEquals("Constant", parserTest.getSymbol("100.0"));
    assertEquals("Constant", parserTest.getSymbol("100.001"));
    assertEquals("Constant", parserTest.getSymbol("0.001"));
    assertEquals("Constant", parserTest.getSymbol("-0.001"));
  }

  @Test
  void testEmptyStringsProduceErrors () {
    assertThrows(IllegalArgumentException.class, () -> parserTest.getSymbol(null));
    assertThrows(IllegalArgumentException.class, () -> parserTest.getSymbol(""));
    assertThrows(IllegalArgumentException.class, () -> parserTest.getSymbol(" "));
  }

  @Test
  void testReadLanguageProperties () {
    final String COMMAND = "Forward";
    assertEquals("forward|fd", parserTest.getCommand(COMMAND));
    parserTest.changeLanguage("Spanish");
    assertEquals("avanzar|ava", parserTest.getCommand(COMMAND));
  }
}
