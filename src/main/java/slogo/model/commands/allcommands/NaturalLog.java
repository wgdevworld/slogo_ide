package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaturalLog extends Commands {

    private double a;
    private double value;

    /**
     * Constructs a new NaturalLog object with default values.
     */
    public NaturalLog() {
        a = 1;
        value = 0;
    }

    /**
     * Constructs a new NaturalLog object with the specified parameters.
     *
     * @param params a list of parameters for the "NaturalLog" command
     */
    public NaturalLog(List<String> params) {
        a = Double.parseDouble(params.get(0));
        value = logValue(a);
    }

    /**
     * Sets the behavior|values of the "NaturalLog" command instance.
     *
     * @param paramList a list of parameters for the "NaturalLog" command
     * @param turtle    the turtle object
     * @param listStack the stack of lists
     * @param observers the list of observers
     * @return the value of the "NaturalLog" command
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        a = paramList.get(0);
        value = logValue(a);
        return value;
    }

    /**
     * Executes the "NaturalLog" command.
     *
     * @param turtle the turtle object
     * @return the value of the "NaturalLog" command
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    /**
     * Prepares the "NaturalLog" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }

    /**
     * Computes the natural logarithm of a number.
     *
     * @param a the number to take the natural logarithm of
     * @return the natural logarithm of the specified number
     */
    private double logValue(double a) {
        return Math.log(a);
    }
}