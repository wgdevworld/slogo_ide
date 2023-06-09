/**
 * The GreaterThan class represents the "GreaterThan?" Boolean Operation.
 * Returns 1 if the value of expr1|a is strictly greater than the value of expr2|b, otherwise 0.
 */
package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GreaterThan extends Commands {

    private double a;
    private double b;
    private double value;

    /**
     * Constructs a new GreaterThan object with default values.
     */
    public GreaterThan() {
        a = 0;
        b = 0;
        value = 0;
    }

    /**
     * Constructs a new GreaterThan object with the specified parameters.
     *
     * @param params a list of parameters for the "GreaterThan" command
     */
    public GreaterThan(List<String> params) {
        a = Double.parseDouble(params.get(0));
        b = Double.parseDouble(params.get(1));
        value = greaterThanValue(a, b);
    }

    /**
     * Sets the behavior|values of the "GreaterThan" command instance.
     *
     * @param paramList a list of parameters for the "GreaterThan" command
     * @param turtle    the turtle object
     * @param listStack the stack of lists
     * @param observers the list of observers
     * @return the result of the "GreaterThan" command
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        a = paramList.get(0);
        b = paramList.get(1);
        value = greaterThanValue(a, b);
        return value;
    }

    /**
     * Executes the "greater than" command.
     *
     * @param turtle the turtle object
     * @return the result of the "GreaterThan" command
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    /**
     * Prepares the "GreaterThan" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }

    /**
     * Calculates if the first parameter is greater than the second parameter and returns a boolean value accordingly.
     *
     * @param first  the first parameter
     * @param second the second parameter
     * @return 1 if the first value is strictly greater than the second value
     */
    private double greaterThanValue(double first, double second) {
        return first > second ? 1 : 0;
    }
}