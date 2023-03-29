package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Minus extends Commands {

    private double a;
    private double value;

    /**
     * Constructs a new Minus object with default values.
     */
    public Minus() {
        a = 0;
        value = 0;
    }

    /**
     * Constructs a new Minus object with the specified parameters.
     *
     * @param params a list of parameters for the "Minus" command
     */
    public Minus(List<String> params) {
        a = Double.parseDouble(params.get(0));
        value = minusValue(a);
    }

    /**
     * Sets the behavior|values of the "Minus" command instance.
     *
     * @param paramList a list of parameters for the "Minus" command
     * @param turtle    the turtle object
     * @param listStack the stack of lists
     * @param observers the list of observers
     * @return the value of the "Minus" command
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        a = paramList.get(0);
        value = minusValue(a);
        return value;
    }

    /**
     * Executes the "Minus" command.
     *
     * @param turtle the turtle object
     * @return the value of the "Minus" command
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    /**
     * Prepares the "Minus" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }

    /**
     * Computes the value of the "Minus" command.
     *
     * @param first the number to be negated
     * @return the negated value of the specified number
     */
    private double minusValue(double first) {
        return -first;
    }
}