/**
 * The ListEnd class represents the end of a list.
 * This command is used as a marker to indicate the end of a list of commands.
 */
package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ListEnd extends Commands {
    /**
     * Sets the behavior|values of the "ListEnd" command instance.
     *
     * @param paramsList a list of parameters for the "ListEnd" command
     * @param turtle     the turtle object
     * @param listStack  the stack of lists
     * @param observers  the list of observers
     * @return 0
     */
    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        return 0;
    }

    /**
     * Executes the "ListEnd" command.
     *
     * @param turtle the turtle object
     * @return 0
     */
    @Override
    public double execute(Turtle turtle) {
        return 0;
    }

    /**
     * Prepares the "ListEnd" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }
}
