/**
 * The Not class represents the "Not" Boolean Operation.
 * returns 1 if a is 0 and 0 if a is non-zero
 */
package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Not extends Commands {

    private double a;
    private double value;

    /**
     * Constructs a new Not object with default values.
     */
    public Not() {
        a = 0;
        value = 0;
    }

    /**
     * Constructs a new Not object with the specified parameters.
     *
     * @param params a list of parameters for the "Not" command
     */
    public Not(List<String> params) {
        a = Double.parseDouble(params.get(0));
        value = notValue(a);
    }

    /**
     * Sets the behavior|values of the "Not" command instance.
     *
     * @param paramList a list of parameters for the "Not" command
     * @param turtle
     * @param listStack
     * @param observers
     * @return the result of the "Not" command
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        a = paramList.get(0);
        value = notValue(a);
        return value;
    }

    /**
     * Executes the "not" command.
     *
     * @param turtle the turtle object
     * @return the result of the "Not" command
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    @Override
    public void prep(String commandString) {

    }

    /**
     * Calculates if the test value is zero.
     *
     * @param a the test value
     * @return 1 if a is 0, otherwise 0
     */
    private double notValue(double a) {
        return (a == 0) ? 1 : 0;
    }
}