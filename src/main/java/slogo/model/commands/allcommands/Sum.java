package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Sum extends Commands {

    private double a;
    private double b;
    private double value;

    /**
     * Constructs a new Sum object with default values.
     */
    public Sum() {
        a = 0;
        b = 0;
        value = 0;
    }

    /**
     * Constructs a new Sum object with the specified parameters.
     *
     * @param params a list of parameters for the "Sum" command
     */
    public Sum(List<String> params) {
        a = Double.parseDouble(params.get(0));
        b = Double.parseDouble(params.get(1));
        value = sumValue(a, b);
    }

    /**
     * Sets the behavior|values of the "Sum" command instance.
     *
     * @param paramList a list of parameters for the "Sum" command
     * @param turtle    the turtle object
     * @param listStack the stack of lists
     * @param observers the list of observers
     * @return the result of the "Sum" command
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        a = paramList.get(0);
        b = paramList.get(1);
        value = sumValue(a, b);
        return value;
    }

    /**
     * Executes the "Sum" command.
     *
     * @param turtle the turtle object
     * @return the result of the "Sum" command
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    /**
     * Prepares the "Sum" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }

    /**
     * Computes the sum of two given numbers.
     *
     * @param first  the first number to be added
     * @param second the second number to be added
     * @return the sum of the two numbers
     */
    private double sumValue(double first, double second) {
        return first + second;
    }
}
