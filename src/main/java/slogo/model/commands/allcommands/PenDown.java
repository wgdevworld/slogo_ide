package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PenDown extends Commands implements Executable {

    /**
     * Constructs a new PenDown object.
     */
    public PenDown() {
    }

    /**
     * Constructs a new PenDown object with the specified parameters.
     *
     * @param params a list of parameters for the "PenDown" command
     */
    public PenDown(List<String> params) {
    }

    /**
     * Sets the behavior|values of the "PenDown" command instance.
     *
     * @param paramList a list of parameters for the "PenDown" command
     * @param turtle    the turtle object
     * @param listStack the stack of lists
     * @param observers the list of observers
     * @return 1
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        return 1;
    }

    /**
     * Executes the "PenDown" command.
     *
     * @param turtle the turtle object
     * @return 1 if the pen is down, 0 otherwise
     */
    @Override
    public double execute(Turtle turtle) {
        turtle.setPenDown(true);
        return turtle.isPenDown() ? 1 : 0;
    }

    /**
     * Prepares the "PenDown" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }
}