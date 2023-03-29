/**
 * The Home class represents the "Home" command.
 * Returns the distance traveled by the turtle to get home and sends the turtle home (to coordinates (0,0)).
 */
package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Home extends Commands implements Executable {

    /**
     * Constructs a new Home object.
     */
    public Home() {
    }

    /**
     * Constructs a new Home object with the specified parameters.
     *
     * @param params a list of parameters for the "Home" command
     */
    public Home(List<String> params) {
    }

    /**
     * Sets the behavior|values of the "Home" command instance.
     *
     * @param paramList a list of parameters for the "Home" command
     * @param turtle    the turtle object
     * @param listStack the stack of lists
     * @param observers the list of observers
     * @return 1
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        return 1;
    }

    /**
     * Executes the "Home" command.
     *
     * @param turtle the turtle object
     * @return the distance traveled by the turtle to get home
     */
    @Override
    public double execute(Turtle turtle) {
        final double coordinate = 0;
        double distance = Math.hypot(turtle.getX() - coordinate, turtle.getY() - coordinate);
        turtle.setPosition(coordinate, coordinate);
        turtle.setDirection(0);
        return Math.abs(distance);
    }

    /**
     * Prepares the "Home" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }
}