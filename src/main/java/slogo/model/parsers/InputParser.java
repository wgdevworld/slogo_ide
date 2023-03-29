package slogo.model.parsers;


import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.CtrlCommand;
import slogo.model.commands.VarCommand;
import slogo.model.commands.allcommands.Conditional;
import slogo.model.commands.allcommands.Constant;
import slogo.model.commands.allcommands.Empty;
import slogo.model.commands.Executable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import slogo.model.commands.allcommands.ListEnd;
import slogo.model.commands.allcommands.ListStart;
import slogo.model.commands.allcommands.Variable;

public class InputParser extends Parser {
  /*
  this class should take in a user input and parse it into a Commands,
  Variable, or Expression object for the program to use.
   */

    private String myInput;
    private List<String> commandList;
    private final Turtle turtle;
    private List<TurtleObserver> observers = new ArrayList<>();
    private static final String PACKAGE_NAME = "slogo.model.commands.allcommands.";
    public Stack<Commands> allCommands = new Stack<>();

    private Stack<ArrayList<String>> listStack = new Stack<>();

    public InputParser() {
        super();
        turtle = new Turtle();
    }

    public InputParser(Turtle turtle, List<TurtleObserver> observers) {
        super();
        this.turtle = turtle;
        this.observers = observers;
    }

    public void addObserver(TurtleObserver observer) {
        observers.add(observer);
    }

    public Turtle getTurtle() {
        return turtle;
    }

    public void tokenize() {
        // regular expression representing one or more whitespace characters (space, tab, or newline)
        final String WHITESPACE = "\\s+";
        commandList = new ArrayList<>();
        for (String symbol : myInput.split(WHITESPACE)) {
            commandList.add(String.format("%s | %s", symbol, getSymbol(symbol)));
            //TODO: add logic here to create instances of variables, commands, or expressions
        }
    }

    @Override
    public void parseProgramCode(String input) throws Exception {
        myInput = input;
        tokenize();
        parseTokenizedInput(commandList);
    }

    public Stack<Double> parseTokenizedInput(List<String> tokenizedCommands) throws Exception {

        ArrayList<String> list = new ArrayList<>();
        Stack<Commands> commandStack = new Stack<>();
        commandStack.push(new Empty());
        boolean activeList = false;
        int activeLists = 0;

        int i = 0;
        for (String commandString : tokenizedCommands) {
            String commandType = commandString.split("\\|")[1].trim();
            Class<?> commandClass = Class.forName(PACKAGE_NAME + commandType);
            Commands commandObj = (Commands) commandClass.getConstructor().newInstance();

            if (commandObj instanceof Constant) {
                Double Constant = Double.parseDouble(commandString.split("\\|")[0].trim());
                ((Constant) commandObj).set(Constant);
            } else if (commandObj instanceof Variable) {
                String name = commandString.split("\\|")[0].trim().split(":")[1].trim();
                ((Variable) commandObj).set(name);
            }
//            if (commandObj instanceof Executable && !(commandStack.peek() instanceof Executable) && !activeList) {
//                parseCommandStack(commandStack);
//            }
            if (commandObj instanceof ListStart && !activeList) {
                list = new ArrayList<>();
                activeList = true;
                activeLists++;
            } else if (commandObj instanceof ListEnd) {
                activeLists--;
                if (activeLists == 0) {
                    activeList = false;
                    listStack.push(list);
                }
            }
            if (activeList) {
                list.add(commandString);
            } else {
                commandStack.push(commandObj);
            }
            allCommands.push(commandObj);
            i++;
        }
        return (listStack.isEmpty()) ? parseCommandStack(commandStack) : parseCommandStack(allCommands);
    }


    public Stack<Double> parseCommandStack(Stack<Commands> commandStack) throws Exception {
        Stack<Double> valueStack = new Stack<>();
        Stack<Commands> executeStack = new Stack<>();
        Stack<List<String>> ctrlLists = new Stack<>();

        while (!commandStack.isEmpty()) {
            Commands command = commandStack.pop();
            XMLParser xml = new XMLParser();

            if (command instanceof VarCommand) {
                ((VarCommand) command).setVar(((Variable) executeStack.peek()).getName());
            } else if (command instanceof Conditional) {
                ((Conditional) command).evaluateBoolean(executeStack.pop(), turtle);
                executeStack = ((Conditional) command).setConditions(executeStack);
            }

            String commandType = command.getClass().getSimpleName();
            double paramNumbers = xml.getParamCount(commandType);
            ArrayList<Double> paramList = new ArrayList<>();
            for (double i = 0; i < paramNumbers; i++) {
                paramList.add(valueStack.pop()); //may add parameters in the wrong order can adjust Command classes for this or change line
            }

            if (command instanceof CtrlCommand) {
                for (int i = 0; i < ((CtrlCommand) command).getPops(); i++) {
                    ArrayList<String> paramCmd = listStack.pop();
                    paramCmd.remove(0);
                    ctrlLists.push(paramCmd);
                }
                valueStack.push(
                    ((CtrlCommand) command).setBehavior(ctrlLists, paramList, turtle, observers));
            } else {
                valueStack.push(command.setBehavior(paramList, turtle)); //setBehavior returns return value and sets internal value for execute
            }

            executeStack.push(command);
        }
            execute(executeStack);
        return valueStack;
    }

    private void notifyObservers() {
        for (TurtleObserver observer : observers) {
            observer.updateTurtleState();
        }
    }

    private void execute(Stack<Commands> commands) {
        while (!commands.isEmpty()) {
            Commands cmd = commands.pop();
            cmd.execute(turtle);
            notifyObservers();
        }
    }

    public Stack<Commands> getCommands() {
        return allCommands;
    }
    public void addObservers(List<TurtleObserver> observers) {
        this.observers.addAll(observers);
    }

}
