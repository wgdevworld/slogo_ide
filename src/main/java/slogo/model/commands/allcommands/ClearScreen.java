package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * The ClearScreen class represents the "ClearScreen" command in SLogo. It clears the turtle's trails and sends it to the
 * home position.
 * <p>
 * It does not take any parameters and returns the distance the turtle moved to get to the home position (0,0).
 */
public class ClearScreen extends Commands implements Executable {

    /**
     * Constructs a ClearScreen object with default values.
     */
    public ClearScreen() {
    }

    /**
     * Constructs a ClearScreen object with the specified parameters. This command does not take any parameters, so the
     * constructor is empty.
     *
     * @param params a list of parameters for the "ClearScreen" command
     */
    public ClearScreen(List<String> params) {
    }

    /**
     * Sets the behavior|values of the "ClearScreen" command instance.
     *
     * @param paramList a list of parameters for the "ClearScreen" command
     * @param turtle    the turtle object
     * @param listStack the stack of lists of commands
     * @param observers the list of TurtleObserver objects
     * @return the distance the turtle moved to get to the home position
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        return 1;
    }

    /**
     * Executes the "ClearScreen" command. It clears the turtle's trails and sends it to the home position.
     *
     * @param turtle the turtle object
     * @return the distance the turtle moved to get to the home position
     */
    @Override
    public double execute(Turtle turtle) {
        final double coordinate = 0;
        double distance = Math.hypot(turtle.getX() - coordinate, turtle.getY() - coordinate);
        turtle.clearScreen();
        return distance;
    }

    /**
     * Prepares the "ClearScreen" command for execution.
     *
     * @param commandString a String of the command
     */
    @Override
    public void prep(String commandString) {

    }
}