package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Forward extends Commands implements Executable {
    private double distance;

    /**
     * Constructs a new Forward object with default values.
     */
    public Forward() {
        distance = 0;
    }

    /**
     * Constructs a new Forward object with the specified parameters.
     *
     * @param params a list of parameters for the "Forward" command
     */
    public Forward(List<String> params) {
        distance = Integer.parseInt(params.get(0));
    }

    /**
     * Sets the behavior|values of the "Forward" command instance.
     *
     * @param paramList a list of parameters for the "Forward" command
     * @param turtle    the turtle object
     * @param listStack the stack of lists
     * @param observers the list of observers
     * @return the distance of the "Forward" command
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        distance = paramList.get(0);
        return distance;
    }

    /**
     * Executes the "Forward" command.
     *
     * @param turtle the turtle object
     * @return the absolute distance of the "Forward" command
     */
    @Override
    public double execute(Turtle turtle) {
        double angle = Math.toRadians(turtle.getDirection());
        double dx = Math.cos(angle) * distance;
        double dy = Math.sin(angle) * distance;
        turtle.setPosition(turtle.getX() + dx, turtle.getY() + dy);
        return Math.abs(distance);
    }

    /**
     * Prepares the "Forward" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {


    }
}