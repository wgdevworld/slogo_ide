package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShowTurtle extends Commands implements Executable {

    /**
     * Constructs a new ShowTurtle object.
     */
    public ShowTurtle() {
    }

    /**
     * Constructs a new ShowTurtle object with the specified parameters.
     *
     * @param params a list of parameters for the "ShowTurtle" command
     */
    public ShowTurtle(List<String> params) {
    }

    /**
     * Sets the behavior|values of the "ShowTurtle" command instance.
     *
     * @param paramsList a list of parameters for the "ShowTurtle" command
     * @param turtle     the turtle object
     * @param listStack  the stack of lists
     * @param observers  the list of observers
     * @return 1, indicating that the command was successfully executed
     */
    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        return 1;
    }

    /**
     * Executes the "ShowTurtle" command.
     *
     * @param turtle the turtle object
     * @return 1 if the turtle is now visible, 0 otherwise
     */
    @Override
    public double execute(Turtle turtle) {
        turtle.setVisibility(true);
        return turtle.isVisible() ? 1 : 0;
    }

    /**
     * Prepares the "ShowTurtle" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }
}
