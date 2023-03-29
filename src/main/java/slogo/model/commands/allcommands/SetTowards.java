package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetTowards extends Commands implements Executable {

    private double x;
    private double y;

    /**
     * Constructs a new SetTowards object with default values.
     */
    public SetTowards() {
        x = 0;
        y = 0;
    }

    /**
     * Constructs a new SetTowards object with the specified parameters.
     *
     * @param params a list of parameters for the "SetTowards" command
     */
    public SetTowards(List<String> params) {
        x = Double.parseDouble(params.get(0));
        y = Double.parseDouble(params.get(1));
    }

    /**
     * Sets the behavior|values of the "SetTowards" command instance.
     *
     * @param paramsList a list of parameters for the "SetTowards" command
     * @param turtle     the turtle object
     * @param listStack  the stack of lists
     * @param observers  the list of observers
     * @return 1, indicating that the command was successfully executed
     */
    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        x = paramsList.get(0);
        y = paramsList.get(1);
        return 1;
    }

    /**
     * Executes the "SetTowards" command.
     *
     * @param turtle the turtle object
     * @return the absolute degrees between the previous direction and the new direction
     */
    @Override
    public double execute(Turtle turtle) {
        double dx = x - turtle.getX();
        double dy = y - turtle.getY();
        double degrees = Math.toDegrees(Math.atan2(-1 * dy, dx));
        turtle.setDirection(degrees);
        return Math.abs(degrees);
    }

    /**
     * Prepares the "SetTowards" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }
}