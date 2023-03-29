/**
 * The HideTurtle class represents the "HideTurtle" command.
 * Makes the turtle invisible.
 */
package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class HideTurtle extends Commands implements Executable {

    /**
     * Constructs a new HideTurtle object.
     */
    public HideTurtle() {
    }

    /**
     * Constructs a new HideTurtle object with the specified parameters.
     *
     * @param params a list of parameters for the "HideTurtle" command
     */
    public HideTurtle(List<String> params) {
    }

    /**
     * Sets the behavior|values of the "HideTurtle" command instance.
     *
     * @param paramsList a list of parameters for the "HideTurtle" command
     * @param turtle     the turtle object
     * @param listStack  the stack of lists
     * @param observers  the list of observers
     * @return 0
     */
    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        return 0;
    }

    /**
     * Executes the "HideTurtle" command.
     *
     * @param turtle the turtle object
     * @return 1 if the turtle is visible, 0 otherwise
     */
    @Override
    public double execute(Turtle turtle) {
        turtle.setVisibility(false);
        return turtle.isVisible() ? 1 : 0;
    }

    /**
     * Prepares the "HideTurtle" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }
}