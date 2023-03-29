package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SquareRoot extends Commands {

    private double a;
    private double value;

    /**
     * Constructs a new SquareRoot object with default values.
     */
    public SquareRoot() {
        a = 0;
        value = 0;
    }

    /**
     * Constructs a new SquareRoot object with the specified parameters.
     *
     * @param params a list of parameters for the "SquareRoot" command
     */
    public SquareRoot(List<String> params) {
        a = Double.parseDouble(params.get(0));
        value = sqrtValue(a);
    }

    /**
     * Sets the behavior|values of the "SquareRoot" command instance.
     *
     * @param paramList a list of parameters for the "SquareRoot" command
     * @param turtle    the turtle object
     * @param listStack the stack of lists
     * @param observers the list of observers
     * @return the result of the "SquareRoot" command
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        a = paramList.get(0);
        value = sqrtValue(a);
        return value;
    }

    /**
     * Executes the "SquareRoot" command.
     *
     * @param turtle the turtle object
     * @return the result of the "SquareRoot" command
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    /**
     * Prepares the "SquareRoot" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }

    /**
     * Calculates the square root of the given value.
     *
     * @param a the input value
     * @return the square root of the input value
     */
    private double sqrtValue(double a) {
        return Math.sqrt(a);
    }
}