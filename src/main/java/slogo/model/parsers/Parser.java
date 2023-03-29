/**
 * The Parser class is an abstract class used to provide basic functionality for parsing programs.
 */
package slogo.model.parsers;

import slogo.model.commands.CommandsMap;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

/**
 * Parses a program
 */
public abstract class Parser {
    private static final String LANGUAGE_RESOURCE_PATH = "slogo.languages.";
    private List<Entry<String, Pattern>> myTokens = new ArrayList<>();
    private String myLanguage = "English";

    /**
     * Creates a new Parser object with the default language.
     */
    public Parser() {
        setPatterns(myLanguage);
    }

    /**
     * Changes the current language used by the parser.
     *
     * @param newLanguage The new language to use.
     */
    public void changeLanguage(String newLanguage) {
        myLanguage = newLanguage;
        setPatterns(myLanguage);
    }

    /**
     * Returns the current language used by the parser.
     *
     * @return The current language used by the parser.
     */
    public String getCurrentLanguage() {
        return myLanguage;
    }

    /**
     * Returns the command associated with the given text.
     *
     * @param command The text to get the command for.
     * @return The command associated with the given text.
     * @throws IllegalArgumentException if the given text does not correspond to a command.
     */
    public String getCommand(String command) throws IllegalArgumentException {
        for (Entry<String, Pattern> token : myTokens) {
            if (token.getKey().equalsIgnoreCase(command)) {
                return token.getValue().toString();
            }
        }
        throw new IllegalArgumentException(String.format("Invalid command given: %s", command));
    }

    /**
     * Returns the symbol associated with the given text.
     *
     * @param text The text to get the symbol for.
     * @return The symbol associated with the given text.
     * @throws IllegalArgumentException if the given text does not correspond to a symbol.
     */
    public String getSymbol(String text) throws IllegalArgumentException {
        if (CommandsMap.commandsMap.containsKey(text)) {
            return text;
        }
        for (Entry<String, Pattern> e : myTokens) {
            if (match(text, e.getValue())) {
                return e.getKey();
            }
        }
        throw new IllegalArgumentException(String.format("Invalid command given: %s", text));
    }

    /**
     * Returns true only if given text matches given regular expression pattern.
     *
     * @param text  The text to check.
     * @param regex The regular expression pattern to check against.
     * @return true only if given text matches given regular expression pattern.
     */
    private boolean match(String text, Pattern regex) {
        return text != null && regex.matcher(text.trim()).matches();
    }

    /**
     * Sets the patterns to match against for the given language.
     *
     * @param language The language to set the patterns for.
     */
    public void setPatterns(String language) {
// language specific matches are more specific, so add first to ensure they are checked first
        myTokens = getPatterns(language);
// general checks, added last
        myTokens.addAll(getPatterns("Syntax"));
    }

    /**
     * Adds the given resource file to this language's recognized types.
     *
     * @param language The language to add the resource file to.
     * @return The list of patterns and their associated symbols.
     */
    private List<Entry<String, Pattern>> getPatterns(String language) {
        List<Entry<String, Pattern>> tokens = new ArrayList<>();
        ResourceBundle resources = ResourceBundle.getBundle(LANGUAGE_RESOURCE_PATH + language);
        for (String key : Collections.list(resources.getKeys())) {
            tokens.add(new SimpleEntry<>(key,
                    Pattern.compile(resources.getString(key), Pattern.CASE_INSENSITIVE)));
        }
        return tokens;
    }

    /**
     * Parses the program code.
     *
     * @param input The program code to parse.
     * @throws Exception if there is an error while parsing the program code.
     */
    public abstract void parseProgramCode(String input) throws Exception;
}