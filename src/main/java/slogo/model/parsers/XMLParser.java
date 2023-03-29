package slogo.model.parsers;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLParser extends Parser {

  private Document xmlDoc;
  private static final String COMMAND_RESORUCE_PATH = "src/main/resources/slogo/commands/";

  public XMLParser() {
    super();
  }

  public void loadXMLFile(String commandName) {
    // TODO: check to see if this method should be public or private
    try {
      String filePath = COMMAND_RESORUCE_PATH + commandName + ".xml";
      File xmlFile = new File(filePath);
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(xmlFile);
      doc.getDocumentElement().normalize();
      xmlDoc = doc;

    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public String getAsString(String xmlTag) {
    try {
      Element element = (Element) xmlDoc.getElementsByTagName(xmlTag).item(0);
      return element.getTextContent().trim();
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  protected double getParamCount(String commandType) {
    loadXMLFile(commandType);
    try {
      String intString = getAsString("number-params");
      return Double.parseDouble(intString);
    } catch (Exception e){
      throw new RuntimeException(e.getMessage());
    }
  }

  @Override
  public void parseProgramCode(String input) throws Exception {
  }

}
