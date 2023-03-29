package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Difference extends Commands {

    private double a;
    private double b;
    private double value;

    /**
     * Constructs a new Difference object with default values.
     */
    public Difference() {
        a = 0;
        b = 0;
        value = 0;
    }

    /**
     * Constructs a new Difference object with the specified parameters.
     *
     * @param params a list of parameters for the "Difference" command
     */
    public Difference(List<String> params) {
        a = Double.parseDouble(params.get(0));
        b = Double.parseDouble(params.get(1));
        value = diffValue(a, b);
    }

    /**
     * Sets the behavior|values of the "Difference" command instance.
     *
     * @param paramList a list of parameters for the "Difference" command
     * @param turtle    the turtle object
     * @param listStack the stack of lists
     * @param observers the list of observers
     * @return the result of the "Difference" command
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        a = paramList.get(0);
        b = paramList.get(1);
        value = diffValue(a, b);
        return value;
    }

    /**
     * Executes the "Difference" command.
     *
     * @param turtle the turtle object
     * @return the result of the "Difference" command
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    /**
     * Prepares the "Difference" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }

    /**
     * Calculates the difference between two values.
     *
     * @param first  the first value
     * @param second the second value
     * @return the difference between the two values
     */
    private double diffValue(double first, double second) {
        return first - second;
    }
}