package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pi extends Commands {

    /**
     * Constructs a new Pi object.
     */
    public Pi() {
    }

    /**
     * Constructs a new Pi object with the specified parameters.
     *
     * @param params a list of parameters for the "Pi" command
     */
    public Pi(List<String> params) {
    }

    /**
     * Sets the behavior|values of the "Pi" command instance.
     *
     * @param paramsList a list of parameters for the "Pi" command
     * @param turtle     the turtle object
     * @param listStack  the stack of lists
     * @param observers  the list of observers
     * @return the value of pi
     */
    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        return Math.PI;
    }

    /**
     * Executes the "Pi" command.
     *
     * @param turtle the turtle object
     * @return the value of pi
     */
    @Override
    public double execute(Turtle turtle) {
        return Math.PI;
    }

    /**
     * Prepares the "Pi" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }
}