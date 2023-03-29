package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class XCoordinate extends Commands {

    /**
     * Constructs a new XCoordinate object.
     */
    public XCoordinate() {
    }

    /**
     * Constructs a new XCoordinate object with the specified parameters.
     *
     * @param params a list of parameters for the "XCoordinate" command
     */
    public XCoordinate(ArrayList<String> params) {
    }

    /**
     * Sets the behavior|values of the "XCoordinate" command instance.
     *
     * @param paramsList a list of parameters for the "XCoordinate" command
     * @param turtle     the turtle object
     * @param listStack  the stack of lists
     * @param observers  the list of observers
     * @return the x-coordinate of the turtle
     */
    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        return turtle.getX();
    }

    /**
     * Executes the "XCoordinate" command.
     *
     * @param turtle the turtle object
     * @return the x-coordinate of the turtle
     */
    @Override
    public double execute(Turtle turtle) {
        return turtle.getX();
    }

    /**
     * Prepares the "XCoordinate" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }
}
