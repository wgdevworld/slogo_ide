/**
 * The Left class represents the "Left" command.
 * Turns the turtle left by the specified number of degrees and returns the absolute value of the degrees turned.
 */
package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Left extends Commands implements Executable {

    private double degrees;

    /**
     * Constructs a new Left object with default values.
     */
    public Left() {
        degrees = 0;
    }

    /**
     * Constructs a new Left object with the specified parameters.
     *
     * @param params a list of parameters for the "Left" command
     */
    public Left(List<String> params) {
        degrees = -1 * Double.parseDouble(params.get(0));
    }

    /**
     * Sets the behavior|values of the "Left" command instance.
     *
     * @param paramList a list of parameters for the "Left" command
     * @param turtle    the turtle object
     * @param listStack the stack of lists
     * @param observers the list of observers
     * @return the number of degrees turned
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        degrees = -1 * paramList.get(0);
        return degrees;
    }

    /**
     * Executes the "Left" command.
     *
     * @param turtle the turtle object
     * @return the absolute value of the number of degrees turned
     */
    @Override
    public double execute(Turtle turtle) {
        turtle.setDirection(turtle.getDirection() + degrees);
        return Math.abs(degrees);
    }

    /**
     * Prepares the "Left" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }
}