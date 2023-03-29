package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Empty extends Commands {

    /**
     * Sets the behavior|values of the "Empty" command instance.
     *
     * @param paramsList a list of parameters for the "Empty" command
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
     * Executes the "Empty" command.
     *
     * @param turtle the turtle object
     * @return 0
     */
    @Override
    public double execute(Turtle turtle) {
        return 0;
    }

    /**
     * Prepares the "Empty" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }
}