package slogo.model.parsers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class XMLParserTest {

  private XMLParser xmlp;

  @BeforeEach
  void setUp() {
    xmlp = new XMLParser();
  }

  @Test
  void testXMLFileLoader() {
    assertDoesNotThrow(() -> {xmlp.loadXMLFile("Forward");});
    assertDoesNotThrow(() -> {xmlp.loadXMLFile("Random");});
    Throwable exception = assertThrows(RuntimeException.class, () -> {
      xmlp.loadXMLFile("FakeCommandName");
    });
    assertTrue(exception.getMessage().contains("No such file or directory"));
  }

  @Test
  void getParamCount() {
    assertEquals(2, xmlp.getParamCount("RandomRange"));
    assertEquals(0, xmlp.getParamCount("PenDown"));
    Throwable exception = assertThrows(RuntimeException.class, () -> {
      xmlp.loadXMLFile("FakeCommandName");
    });
    assertTrue(exception.getMessage().contains("No such file or directory"));
  }

}