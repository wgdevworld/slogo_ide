package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Backward extends Commands implements Executable {
    private double distance;

    /**
     * Constructs a new Backward object with default values.
     */
    public Backward() {
        distance = 0;
    }

    /**
     * Constructs a new Backward object with the specified parameters.
     *
     * @param params a list of parameters for the "Backward" command
     */
    public Backward(List<String> params) {
        distance = -1 * Integer.parseInt(params.get(0));
    }

    /**
     * Sets the behavior|values of the "Backward" command instance.
     *
     * @param paramList a list of parameters for the "Backward" command
     * @param turtle    the turtle object
     * @param listStack the list stack
     * @param observers the list of turtle observers
     * @return the distance the turtle moved backwards
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        distance = -1 * paramList.get(0);
        return Math.abs(distance);
    }

    /**
     * Executes the "Backward" command.
     *
     * @param turtle the turtle object
     * @return the distance the turtle moved backwards
     */
    @Override
    public double execute(Turtle turtle) {
        double angle = Math.toRadians(turtle.getDirection());
        double dx = Math.cos(angle) * distance;
        double dy = Math.sin(angle) * distance;
        turtle.setPosition(turtle.getX() + dx, turtle.getY() + dy);
        return Math.abs(distance);
    }

    @Override
    public void prep(String commandString) {

    }
}
