/**
 * The Or class represents the "Or" Boolean Operation.
 * returns 1 if a or b are non-zero, otherwise 0
 */
package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Or extends Commands {

    private double a;
    private double b;
    private double value;

    /**
     * Constructs a new Or object with default values.
     */
    public Or() {
        a = 0;
        b = 0;
        value = 0;
    }

    /**
     * Constructs a new Or object with the specified parameters.
     *
     * @param params a list of parameters for the "Or" command
     */
    public Or(List<String> params) {
        a = Double.parseDouble(params.get(0));
        b = Double.parseDouble(params.get(1));
        value = orValue(a, b);
    }

    /**
     * Sets the behavior|values of the "Or" command instance.
     *
     * @param paramList a list of parameters for the "Or" command
     * @param turtle
     * @param listStack
     * @param observers
     * @return the result of the "Or" command
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        a = paramList.get(0);
        b = paramList.get(1);
        value = orValue(a, b);
        return value;
    }

    /**
     * Executes the "or" command.
     *
     * @param turtle the turtle object
     * @return the result of the "Or" command
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    @Override
    public void prep(String commandString) {

    }

    /**
     * Calculates if either a or b are non-zero.
     *
     * @param a the first test value
     * @param b the second test value
     * @return 1 if either a or b are non-zero
     */
    private double orValue(double a, double b) {
        return (a != 0 || b != 0) ? 1 : 0;
    }
}