package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;
import slogo.model.parsers.InputParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Repeat extends Commands implements Executable {

    private double value;

    /**
     * Sets the behavior|values of the "Repeat" command instance.
     *
     * @param paramsList a list of parameters for the "Repeat" command
     * @param turtle     the turtle object
     * @param listStack  the stack of lists
     * @param observers  the list of observers
     * @return the value of the last executed command inside the repeat block
     * @throws Exception if an error occurs during parsing of the repeat block
     */
    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) throws Exception {
        ArrayList<String> commandsStack = listStack.pop();
        commandsStack.remove(0);
        InputParser parser = new InputParser(turtle, observers);
        double times = paramsList.get(0);

        for (int i = 0; i < times; i++) {
            value = parser.parseTokenizedInput(commandsStack).peek();
        }
        return value;
    }

    /**
     * Executes the "Repeat" command.
     *
     * @param turtle the turtle object
     * @return the value of the last executed command inside the repeat block
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    /**
     * Prepares the "Repeat" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }
}