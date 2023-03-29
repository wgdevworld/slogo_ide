/**
 * The XMLParser class is used to parse XML files containing information about commands.
 */
package slogo.model.parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Parses XML files containing information about commands.
 */
public class XMLParser extends Parser {
    private static final String COMMAND_RESOURCE_PATH = "src/main/resources/slogo/commands/";
    private Document xmlDoc;

    /**
     * Creates a new XMLParser object.
     */
    public XMLParser() {
        super();
    }

    /**
     * Loads the XML file with the given command name.
     *
     * @param commandName The name of the command to load.
     */
    public void loadXMLFile(String commandName) {
        try {
            String filePath = COMMAND_RESOURCE_PATH + commandName + ".xml";
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

    /**
     * Returns the content of the specified XML tag.
     *
     * @param xmlTag The name of the XML tag to get the content for.
     * @return The content of the specified XML tag.
     * @throws RuntimeException if there is an error while getting the content of the specified XML tag.
     */
    public String getAsString(String xmlTag) {
        try {
            Element element = (Element) xmlDoc.getElementsByTagName(xmlTag).item(0);
            return element.getTextContent().trim();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Returns the number of parameters for the specified command type.
     *
     * @param commandType The command type to get the number of parameters for.
     * @return The number of parameters for the specified command type.
     * @throws RuntimeException if there is an error while getting the number of parameters for the specified command type.
     */
    protected double getParamCount(String commandType) {
        loadXMLFile(commandType);
        try {
            String intString = getAsString("number-params");
            return Double.parseDouble(intString);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Returns the value of the specified property for the specified command type.
     *
     * @param commandType The command type to get the value for.
     * @param property    The property to get the value for.
     * @return The value of the specified property for the specified command type.
     * @throws RuntimeException if there is an error while getting the value of the specified property for the specified command type.
     */
    public double getValue(String commandType, String property) {
        loadXMLFile(commandType);
        try {
            String intString = getAsString(property);
            return Double.parseDouble(intString);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * An unnecessary method that is a leftover from this incorrectly extending parser
     *
     * @param input The program code to parse.
     * @throws Exception
     */
    @Override
    public void parseProgramCode(String input) throws Exception {
    }

}
