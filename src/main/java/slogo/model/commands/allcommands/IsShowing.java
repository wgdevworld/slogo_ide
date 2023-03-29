/**
 * The IsShowing class represents the "IsShowing" command.
 * Returns 1 if the turtle is visible, 0 otherwise.
 */
package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IsShowing extends Commands {

    /**
     * Constructs a new IsShowing object.
     */
    public IsShowing() {
    }

    /**
     * Constructs a new IsShowing object with the specified parameters.
     *
     * @param params a list of parameters for the "IsShowing" command
     */
    public IsShowing(List<String> params) {
    }

    /**
     * Sets the behavior|values of the "IsShowing" command instance.
     *
     * @param paramsList a list of parameters for the "IsShowing" command
     * @param turtle     the turtle object
     * @param listStack  the stack of lists
     * @param observers  the list of observers
     * @return 1 if the turtle is visible, 0 otherwise
     */
    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        return turtle.isVisible() ? 1 : 0;
    }

    /**
     * Executes the "IsShowing" command.
     *
     * @param turtle the turtle object
     * @return 1 if the turtle is visible, 0 otherwise
     */
    @Override
    public double execute(Turtle turtle) {
        return turtle.isVisible() ? 1 : 0;
    }

    /**
     * Prepares the "IsShowing" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }
}