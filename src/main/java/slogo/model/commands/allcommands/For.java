/**

 The For class implements the Executable interface and represents the "for" command in the SLogo API.
 It allows for a block of code to be executed repeatedly for a specified range of values of a variable.
 */
package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;
import slogo.model.parsers.InputParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class For extends Commands implements Executable {

    private double value;

    /**
     * Executes the "for" command on a turtle.
     * @param paramsList the list of parameters to the "for" command
     * @param turtle the turtle to execute the command on
     * @param listStack the stack of lists of commands
     * @param observers the list of TurtleObservers observing the turtle
     * @return the final value of the executed command
     * @throws Exception if an error occurs during the execution of the command
     */
    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) throws Exception {

        ArrayList<String> commandsStack = listStack.pop();
        commandsStack.remove(0);
        ArrayList<String> iterationList = listStack.pop();
        iterationList.remove(0);

        InputParser parser = new InputParser(turtle, observers);

        Stack<Double> parameterVals = parser.parseTokenizedInput(iterationList);
        Stack<Commands> iterationStack = parser.getCommands();
        Variable variable = (Variable)iterationStack.get(0);
        parameterVals.pop();
        parameterVals.pop();
        double start = parameterVals.pop();
        variable.setVal(start);
        double end = parameterVals.pop();
        double increment = parameterVals.pop();


        while (variable.getVal() < end) {
            value = parser.parseTokenizedInput(commandsStack).peek();
            variable.setVal(variable.getVal() + increment);
        }
        return value;
    }

    /**
     * Executes the "for" command on a turtle.
     * @param turtle the turtle to execute the command on
     * @return the final value of the executed command
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    /**
     * Prepares the "for" command for execution.
     * @param commandString the string representing the "for" command
     */
    @Override
    public void prep(String commandString) {

    }
}
