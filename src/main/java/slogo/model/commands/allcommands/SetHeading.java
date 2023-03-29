package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetHeading extends Commands implements Executable {

    private double degrees;

    /**
     * Constructs a new SetHeading object with default values.
     */
    public SetHeading() {
        degrees = 0;
    }

    /**
     * Constructs a new SetHeading object with the specified parameters.
     *
     * @param params a list of parameters for the "SetHeading" command
     */
    public SetHeading(List<String> params) {
        degrees = Double.parseDouble(params.get(0));
    }

    /**
     * Sets the behavior|values of the "SetHeading" command instance.
     *
     * @param paramsList a list of parameters for the "SetHeading" command
     * @param turtle     the turtle object
     * @param listStack  the stack of lists
     * @param observers  the list of observers
     * @return the degrees of the "SetHeading" command
     */
    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        degrees = paramsList.get(0);
        return degrees;
    }

    /**
     * Executes the "SetHeading" command.
     *
     * @param turtle the turtle object
     * @return the smallest angle (in degrees) between the previous heading and the new heading
     */
    @Override
    public double execute(Turtle turtle) {
        double prevDirection = turtle.getDirection();
        turtle.setDirection(degrees);
        return Math.min(Math.abs(prevDirection - degrees), 360 - Math.abs(prevDirection - degrees));
    }

    /**
     * Prepares the "SetHeading" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }
}