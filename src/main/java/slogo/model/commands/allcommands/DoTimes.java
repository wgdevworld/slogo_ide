package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;
import slogo.model.parsers.InputParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DoTimes extends Commands implements Executable {

    private double value;

    /**
     * Sets the behavior|values of the "DoTimes" command instance.
     *
     * @param paramsList a list of parameters for the "DoTimes" command
     * @param turtle     the turtle object
     * @param listStack  the stack of lists
     * @param observers  the list of observers
     * @return the result of the "DoTimes" command
     * @throws Exception if an error occurs while parsing input
     */
    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) throws Exception {
        ArrayList<String> commandsStack = listStack.pop();
        commandsStack.remove(0);
        ArrayList<String> iterationList = listStack.pop();
        iterationList.remove(0);

        InputParser parser = new InputParser(turtle, observers);

        Stack<Double> paramaterVals = parser.parseTokenizedInput(iterationList);
        Stack<Commands> iterationStack = parser.getCommands();
        Variable variable = (Variable) iterationStack.get(0);
        paramaterVals.pop();
        paramaterVals.pop();
        double limit = paramaterVals.pop();
        variable.setVal(1.0);

        while (variable.getVal() <= limit) {
            value = parser.parseTokenizedInput(commandsStack).peek();
            variable.setVal(variable.getVal() + 1.0);
        }
        return value;
    }

    /**
     * Executes the "DoTimes" command.
     *
     * @param turtle the turtle object
     * @return the result of the "DoTimes" command
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    /**
     * Prepares the "DoTimes" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }
}