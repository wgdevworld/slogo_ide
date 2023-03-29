/**
 * The LessThan class represents the "LessThan?" Boolean Operation.
 * returns 1 if the value of expr1|a is strictly less than the value of expr2|b, otherwise 0
 */
package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LessThan extends Commands {

    private double a;
    private double b;
    private double value;

    /**
     * Constructs a new LessThan object with default values.
     */
    public LessThan() {
        a = 0;
        b = 0;
        value = 0;
    }

    /**
     * Constructs a new LessThan object with the specified parameters.
     *
     * @param params a list of parameters for the "LessThan" command
     */
    public LessThan(List<String> params) {
        a = Double.parseDouble(params.get(0));
        b = Double.parseDouble(params.get(1));
        value = lessThanValue(a, b);
    }

    /**
     * Sets the behavior|values of the "LessThan" command instance.
     *
     * @param paramList a list of parameters for the "LessThan" command
     * @param turtle
     * @param listStack
     * @param observers
     * @return the result of the "LessThan" command
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        a = paramList.get(0);
        b = paramList.get(1);
        value = lessThanValue(a, b);
        return value;
    }

    /**
     * Executes the "less than" command.
     *
     * @param turtle the turtle object
     * @return the result of the "LessThan" command
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    @Override
    public void prep(String commandString) {

    }

    /**
     * Calculates if the first parameter is less than the second.
     *
     * @param first  the first parameter
     * @param second the second parameter
     * @return 1 if the first value is strictly less than the second value
     */
    private double lessThanValue(double first, double second) {
        return first < second ? 1 : 0;
    }
}