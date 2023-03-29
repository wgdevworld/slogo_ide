package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class YCoordinate extends Commands {

    /**
     * Constructs a new YCoordinate object.
     */
    public YCoordinate() {
    }

    /**
     * Constructs a new YCoordinate object with the specified parameters.
     *
     * @param params a list of parameters for the "YCoordinate" command
     */
    public YCoordinate(ArrayList<String> params) {
    }

    /**
     * Sets the behavior|values of the "YCoordinate" command instance.
     *
     * @param paramsList a list of parameters for the "YCoordinate" command
     * @param turtle     the turtle object
     * @param listStack  the stack of lists
     * @param observers  the list of observers
     * @return the y-coordinate of the turtle
     */
    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        return turtle.getY();
    }

    /**
     * Executes the "YCoordinate" command.
     *
     * @param turtle the turtle object
     * @return the y-coordinate of the turtle
     */
    @Override
    public double execute(Turtle turtle) {
        return turtle.getY();
    }

    /**
     * Prepares the "YCoordinate" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }
}
