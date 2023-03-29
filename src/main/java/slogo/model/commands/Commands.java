package slogo.model.commands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class Commands {

    /**
     * Constructs a new Commands object.
     */
    public Commands() {
    }

    /**
     * Sets the behavior|values of the command instance.
     *
     * @param paramsList a list of parameters for the command
     * @param turtle     the turtle object
     * @param listStack  the stack of lists
     * @param observers  the list of observers
     * @return the result of setting the behavior
     * @throws Exception if an error occurs while setting the behavior
     */
    public abstract double setBehavior(ArrayList<Double> paramsList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) throws Exception;

    /**
     * Executes the command.
     *
     * @param turtle the turtle object
     * @return the result of executing the command
     */
    public abstract double execute(Turtle turtle);

    /**
     * Prepares the command.
     *
     * @param commandString the string representation of the command
     */
    public abstract void prep(String commandString);

}