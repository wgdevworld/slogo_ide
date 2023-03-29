/**
 * The ListStart class represents the beginning of a list command.
 * It extends the Commands class and provides an implementation for the setBehavior, execute, and prep methods.
 */
package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ListStart extends Commands {
    /**
     * Sets the behavior of the "ListStart" command instance.
     * This method is not used in the ListStart command.
     *
     * @param paramList a list of parameters for the "ListStart" command
     * @param turtle
     * @param listStack
     * @param observers
     * @return 0
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        return 0;
    }

    /**
     * Executes the "ListStart" command.
     * This method is not used in the ListStart command.
     *
     * @param turtle the turtle object
     * @return 0
     */
    @Override
    public double execute(Turtle turtle) {
        return 0;
    }

    /**
     * Preps the "ListStart" command.
     * This method is not used in the ListStart command.
     *
     * @param commandString the command string
     */
    @Override
    public void prep(String commandString) {

    }

}
