package slogo.model.parsers;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public abstract class Parser {

  private List<Entry<String, Pattern>> myTokens = new ArrayList<>();
  private static final String LANGUAGE_RESOURCE_PATH = "slogo.languages.";
  private String myLanguage = "English";

  public Parser() {
    setPatterns(myLanguage);
  }

  public void changeLanguage(String newLanguage) {
    myLanguage = newLanguage;
    setPatterns(myLanguage);
  }

  public String getCurrentLanguage() {
    return myLanguage;
  }

  public String getCommand (String command) throws IllegalArgumentException {
    for (Entry<String, Pattern> token : myTokens) {
      if (token.getKey().equalsIgnoreCase(command)) {
        return token.getValue().toString();
      }
    }
    throw new IllegalArgumentException(String.format("Invalid command given: %s", command));
  }

  /**
   *  Returns token type associated with given text.
   */
  public String getSymbol (String text) throws IllegalArgumentException {
    for (Entry<String, Pattern> e : myTokens) {
      if (match(text, e.getValue())) {
        return e.getKey();
      }
    }
    throw new IllegalArgumentException(String.format("Invalid command given: %s", text));
  }


  // Returns true only if given text matches given regular expression pattern
  private boolean match (String text, Pattern regex) {
    // THIS IS THE IMPORTANT LINE
    return text != null && regex.matcher(text.trim()).matches();
  }


  // Set up matchers, which checks in order given
  public void setPatterns(String language) {
    // language specific matches are more specific, so add first to ensure they are checked first
    myTokens = getPatterns(language);
    // general checks, added last
    myTokens.addAll(getPatterns("Syntax"));
  }


  // Add given resource file to this language's recognized types
  private List<Entry<String, Pattern>> getPatterns(String language) {
    List<Entry<String, Pattern>> tokens = new ArrayList<>();
    ResourceBundle resources = ResourceBundle.getBundle(LANGUAGE_RESOURCE_PATH + language);
    for (String key : Collections.list(resources.getKeys())) {
      tokens.add(new SimpleEntry<>(key,
          // THIS IS THE OTHER IMPORTANT LINE
          Pattern.compile(resources.getString(key), Pattern.CASE_INSENSITIVE)));
    }
    return tokens;
  }

  public abstract void parseProgramCode(String input) throws Exception;

}
