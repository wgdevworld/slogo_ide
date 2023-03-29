package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Heading extends Commands implements Executable {

    /**
     * Constructs a new Heading object.
     */
    public Heading() {
    }

    /**
     * Constructs a new Heading object with the specified parameters.
     *
     * @param params a list of parameters for the "Heading" command
     */
    public Heading(List<String> params) {
    }

    /**
     * Sets the behavior|values of the "Heading" command instance.
     *
     * @param paramsList a list of parameters for the "Heading" command
     * @param turtle     the turtle object
     * @param listStack  the stack of lists
     * @param observers  the list of observers
     * @return the current heading (in degrees) of the turtle
     */
    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        return turtle.getDirection();
    }

    /**
     * Executes the "Heading" command.
     *
     * @param turtle the turtle object
     * @return the current heading (in degrees) of the turtle
     */
    @Override
    public double execute(Turtle turtle) {
        return turtle.getDirection();
    }

    /**
     * Prepares the "Heading" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }
}