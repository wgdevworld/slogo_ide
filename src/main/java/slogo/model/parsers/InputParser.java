/**
 * The InputParser class is responsible for parsing user input and converting it into executable commands.
 */
package slogo.model.parsers;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;
import slogo.model.commands.VarCommand;
import slogo.model.commands.allcommands.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Parses user input into executable commands
 */
public class InputParser extends Parser {

    private static final String PACKAGE_NAME = "slogo.model.commands.allcommands.";
    public Stack<Commands> allCommands = new Stack<>();
    private String myInput;
    private List<String> commandList;
    private final Turtle turtle;
    private List<TurtleObserver> observers = new ArrayList<>();
    private final Stack<ArrayList<String>> listStack = new Stack<>();
    private ArrayList<String> list;

    /**
     * Creates a new instance of InputParser with a default turtle object.
     */
    public InputParser() {
        super();
        turtle = new Turtle();
    }

    /**
     * Creates a new instance of InputParser with a given turtle object and list of observers.
     *
     * @param turtle    The turtle object to use for executing commands.
     * @param observers The list of observers to notify of turtle state changes.
     */
    public InputParser(Turtle turtle, List<TurtleObserver> observers) {
        super();
        this.turtle = turtle;
        this.observers = observers;
    }

    /**
     * Adds an observer to the list of observers to notify of turtle state changes.
     *
     * @param observer The observer to add to the list.
     */
    public void addObserver(TurtleObserver observer) {
        observers.add(observer);
    }

    /**
     * Returns the turtle object being used by the parser.
     *
     * @return The turtle object being used by the parser.
     */
    public Turtle getTurtle() {
        return turtle;
    }

    /**
     * Splits the user input into a list of command strings.
     */
    public List<String> tokenize(String input) {
        final String WHITESPACE = "\s+";
        ArrayList<String> retlist = new ArrayList<>();
        for (String symbol : input.split(WHITESPACE)) {
            retlist.add(String.format("%s | %s", symbol, getSymbol(symbol)));
        }
        return retlist;
    }
    public void tokenize() {
// regular expression representing one or more whitespace characters (space, tab, or newline)
        final String WHITESPACE = "\s+";
        commandList = new ArrayList<>();
        for (String symbol : myInput.split(WHITESPACE)) {
            commandList.add(String.format("%s | %s", symbol, getSymbol(symbol)));
//TODO: add logic here to create instances of variables, commands, or expressions
        }
    }

    /**
     * Parses the given input into executable commands and returns the result.
     *
     * @param input The user input to parse.
     * @throws Exception if parsing fails.
     */
    @Override
    public void parseProgramCode(String input) throws Exception {
        myInput = input;
        tokenize();
        parseTokenizedInput(commandList);
    }

    /**
     * Parses the given list of command strings into executable commands and returns the result.
     *
     * @param tokenizedCommands The list of command strings to parse.
     * @throws Exception if parsing fails.
     */
    public Stack<Double> parseTokenizedInput(List<String> tokenizedCommands) throws Exception {

        Stack<Commands> commandStack = new Stack<>();
        commandStack.push(new Empty());
        int activeLists = 0;

        for (String commandString : tokenizedCommands) {
            String commandType = commandString.split("\\|")[1].trim();

            Class<?> commandClass = Class.forName(PACKAGE_NAME + commandType);
            Commands commandObj = (Commands) commandClass.getConstructor().newInstance();

            commandObj.prep(commandString);
            activeLists = checkExecution(commandObj, commandStack, activeLists, commandString);
            allCommands.push(commandObj);
        }
        return parseCommandStack(commandStack);
        //return (listStack.isEmpty()) ? parseCommandStack(commandStack) : parseCommandStack(allCommands);
    }


    /**
     * Parses the given stack of Commands into executable commands and returns the result.
     *
     * @param commandStack The stack of Commands to parse.
     * @throws Exception if parsing fails.
     */
    public Stack<Double> parseCommandStack(Stack<Commands> commandStack) throws Exception {
        Stack<Double> valueStack = new Stack<>();
        Stack<Commands> executeStack = new Stack<>();
        Stack<List<String>> ctrlLists = new Stack<>();

        while (!commandStack.isEmpty()) {

            Commands command = commandStack.pop();
            XMLParser xml = new XMLParser();

            if (command instanceof VarCommand) {
                int i = 0;
                ((VarCommand) command).setVar(((Variable) executeStack.peek()).getName());
            }

            String commandType = command.getClass().getSimpleName();
            double paramNumbers = xml.getParamCount(commandType);
            ArrayList<Double> paramList = new ArrayList<>();
            for (double i = 0; i < paramNumbers; i++) {
                paramList.add(valueStack.pop()); //may add parameters in the wrong order can adjust Command classes for this or change line
            }
            Collections.reverse(paramList); //fixed above comment won't be added in wrong order

            valueStack.push(command.setBehavior(paramList, turtle, listStack, observers)); //setBehavior returns return value and sets internal value for execute
            executeStack.push(command);
        }
        execute(executeStack);
        return valueStack;
    }

    /**
     * Notifies all observers of turtle state changes.
     */
    private void notifyObservers() {
        for (TurtleObserver observer : observers) {
            observer.updateTurtleState();
        }
    }

    /**
     * Executes the given stack of Commands.
     *
     * @param commands The stack of Commands to execute.
     */
    private void execute(Stack<Commands> commands) {
        while (!commands.isEmpty()) {
            Commands cmd = commands.pop();
            cmd.execute(turtle);
            notifyObservers();
        }
    }

    /**
     * Returns the stack of all Commands created by parsing.
     *
     * @return The stack of all Commands created by parsing.
     */
    public Stack<Commands> getCommands() {
        return allCommands;
    }

    /**
     * Adds a list of observers to the current list of observers.
     *
     * @param observers The list of observers to add.
     */
    public void addObservers(List<TurtleObserver> observers) {
        this.observers.addAll(observers);
    }

    /**
     * Returns the list of observers.
     *
     * @return The list of observers.
     */
    public List<TurtleObserver> getObservers() {
        return observers;
    }

    /**
     * checks for if any commands need the commands before them to be executed and checks any list logic associated with these commands
     *
     * @param commandObj    the current command object to check
     * @param commandStack  the current stack of commands
     * @param lists         the current number of active lists
     * @param commandString the current command String
     * @return return the new number of active lists
     * @throws Exception
     */
    private int checkExecution(Commands commandObj, Stack<Commands> commandStack, int lists, String commandString) throws Exception {

        if (commandObj instanceof Executable && !(commandStack.peek() instanceof Executable) && lists == 0) {
            parseCommandStack(commandStack);
        }

        if (commandObj instanceof ListStart) {
            if (lists == 0) {
                list = new ArrayList<>();
            }
            lists++;
        } else if (commandObj instanceof ListEnd) {
            lists--;
            if (lists == 0) {
                listStack.push(list);
            }
        }

        if (lists != 0) {
            list.add(commandString);
        } else {
            commandStack.push(commandObj);
        }

        return lists;
    }

}
