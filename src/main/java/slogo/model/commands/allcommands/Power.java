package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Power extends Commands {

    private double base;
    private double exponent;
    private double value;

    public Power() {
        base = 0;
        exponent = 0;
        value = 0;
    }

    public Power(List<String> params) {
        base = Double.parseDouble(params.get(0));
        exponent = Double.parseDouble(params.get(1));
        value = powValue(base, exponent);
    }

    /**
     * Sets the behavior|values of the "Power" command instance.
     *
     * @param paramList a list of parameters for the "Power" command
     * @param turtle    the turtle object
     * @param listStack the stack of lists
     * @param observers the list of observers
     * @return the value of base raised to the power of exponent
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        base = paramList.get(0);
        exponent = paramList.get(1);
        value = powValue(base, exponent);
        return value;
    }

    /**
     * Executes the "Power" command.
     *
     * @param turtle the turtle object
     * @return the value of base raised to the power of exponent
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    /**
     * Prepares the "Power" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }

    private double powValue(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}