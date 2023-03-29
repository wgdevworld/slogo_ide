/**

 The If class implements the Executable interface and represents the "If" command in the SLogo API.
 It allows for a block of code to be executed if an expression is true.
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

public class If extends Commands implements Executable {

    private double value;

    /**
     * Executes the "if" command on a turtle.
     * @param paramsList the list of parameters to the "if" command
     * @param turtle the turtle to execute the command on
     * @param listStack the stack of lists of commands
     * @param observers the list of TurtleObservers observing the turtle
     * @return the final value of the executed command
     * @throws Exception if an error occurs during the execution of the command
     */
    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) throws Exception {
        double value = 0;

        ArrayList<String> ifStack = listStack.pop();
        ifStack.remove(0);
        boolean ifbool = (paramsList.get(0) == 1.0) ? true : false;

        InputParser parser = new InputParser(turtle, observers);

        if (ifbool) {
            value = parser.parseTokenizedInput(ifStack).peek();
        }
        return value;
    }

    /**
     * Executes the "if" command on a turtle.
     * @param turtle the turtle to execute the command on
     * @return the final value of the executed command
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    /**
     * Prepares the "if" command for execution.
     * @param commandString the string representing the "if" command
     */
    @Override
    public void prep(String commandString) {

    }
}
