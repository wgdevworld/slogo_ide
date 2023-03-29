package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetPosition extends Commands implements Executable {
    private double x;
    private double y;

    /**
     * Constructs a new SetPosition object with default values.
     */
    public SetPosition() {
        x = 0;
        y = 0;
    }

    /**
     * Constructs a new SetPosition object with the specified parameters.
     *
     * @param params a list of parameters for the "SetPosition" command
     */
    public SetPosition(List<String> params) {
        x = Double.parseDouble(params.get(0));
        y = Double.parseDouble(params.get(1));
    }

    /**
     * Sets the behavior|values of the "SetPosition" command instance.
     *
     * @param paramsList a list of parameters for the "SetPosition" command
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
     * Executes the "SetPosition" command.
     *
     * @param turtle the turtle object
     * @return the absolute distance between the previous position and the new position
     */
    @Override
    public double execute(Turtle turtle) {
        double distance = Math.hypot(turtle.getX() - x, turtle.getY() - y);
        turtle.setPosition(x, (-1 * y));
        return Math.abs(distance);
    }

    /**
     * Prepares the "SetPosition" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }
}
