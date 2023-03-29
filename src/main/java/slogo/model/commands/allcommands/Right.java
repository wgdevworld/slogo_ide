package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Right extends Commands implements Executable {

    private double degrees;

    /**
     * Constructs a new Right object with default values.
     */
    public Right() {
        degrees = 0;
    }

    /**
     * Constructs a new Right object with the specified parameters.
     *
     * @param params a list of parameters for the "Right" command
     */
    public Right(List<String> params) {
        degrees = Double.parseDouble(params.get(0));
    }

    /**
     * Sets the behavior|values of the "Right" command instance.
     *
     * @param paramList a list of parameters for the "Right" command
     * @param turtle    the turtle object
     * @param listStack the stack of lists
     * @param observers the list of observers
     * @return the degrees of the "Right" command
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        degrees = paramList.get(0);
        return degrees;
    }

    /**
     * Executes the "Right" command.
     *
     * @param turtle the turtle object
     * @return the absolute value of the degrees of the "Right" command
     */
    @Override
    public double execute(Turtle turtle) {
        turtle.setDirection(turtle.getDirection() + degrees);
        return Math.abs(degrees);
    }

    /**
     * Prepares the "Right" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }
}