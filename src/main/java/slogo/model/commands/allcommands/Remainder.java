package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Remainder extends Commands {

    private double a;
    private double b;

    private double value;

    /**
     * Constructs a new Remainder object with default values.
     */
    public Remainder() {
        a = 0;
        b = 0;
        value = 0;
    }

    /**
     * Constructs a new Remainder object with the specified parameters.
     *
     * @param params a list of parameters for the "Remainder" command
     */
    public Remainder(List<String> params) {
        a = Double.parseDouble(params.get(0));
        b = Double.parseDouble(params.get(1));
        value = remValue(a, b);
    }

    /**
     * Sets the behavior|values of the "Remainder" command instance.
     *
     * @param paramList a list of parameters for the "Remainder" command
     * @param turtle    the turtle object
     * @param listStack the stack of lists
     * @param observers the list of observers
     * @return the remainder of the division of the first parameter by the second parameter
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        a = paramList.get(0);
        b = paramList.get(1);
        value = remValue(a, b);
        return value;
    }

    /**
     * Executes the "Remainder" command.
     *
     * @param turtle the turtle object
     * @return the remainder of the division of the first parameter by the second parameter
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    /**
     * Prepares the "Remainder" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }

    /**
     * Calculates the remainder of the division of the first parameter by the second parameter.
     *
     * @param first  the dividend
     * @param second the divisor
     * @return the remainder of the division of the first parameter by the second parameter
     */
    private double remValue(double first, double second) {
        return first % second;
    }
}
