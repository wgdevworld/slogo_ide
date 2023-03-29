/**
 * The IsPenDown class represents the "IsPenDown" command.
 * Returns 1 if the turtle's pen is down, 0 otherwise.
 */
package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IsPenDown extends Commands {

    /**
     * Constructs a new IsPenDown object.
     */
    public IsPenDown() {
    }

    /**
     * Constructs a new IsPenDown object with the specified parameters.
     *
     * @param params a list of parameters for the "IsPenDown" command
     */
    public IsPenDown(List<String> params) {
    }

    /**
     * Sets the behavior|values of the "IsPenDown" command instance.
     *
     * @param paramsList a list of parameters for the "IsPenDown" command
     * @param turtle     the turtle object
     * @param listStack  the stack of lists
     * @param observers  the list of observers
     * @return 1 if the turtle's pen is down, 0 otherwise
     */
    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        return turtle.isPenDown() ? 1 : 0;
    }

    /**
     * Executes the "IsPenDown" command.
     *
     * @param turtle the turtle object
     * @return 1 if the turtle's pen is down, 0 otherwise
     */
    @Override
    public double execute(Turtle turtle) {
        return turtle.isPenDown() ? 1 : 0;
    }

    /**
     * Prepares the "IsPenDown" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }
}