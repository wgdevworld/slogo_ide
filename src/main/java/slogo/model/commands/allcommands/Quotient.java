package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Quotient extends Commands {

    private double a;
    private double b;
    private double value;

    public Quotient() {
        a = 0;
        b = 1;
        value = 0;
    }

    public Quotient(List<String> params) {
        a = Double.parseDouble(params.get(0));
        b = Double.parseDouble(params.get(1));
        value = divValue(a, b);
    }

    /**
     * Sets the behavior|values of the "Quotient" command instance.
     *
     * @param paramList a list of parameters for the "Quotient" command
     * @param turtle    the turtle object
     * @param listStack the stack of lists
     * @param observers the list of observers
     * @return the quotient of the two values
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        a = paramList.get(0);
        b = paramList.get(1);
        value = divValue(a, b);
        return value;
    }

    /**
     * Executes the "Quotient" command.
     *
     * @param turtle the turtle object
     * @return the quotient of the two values
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    /**
     * Prepares the "Quotient" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }

    private double divValue(double first, double second) {
        return first / second;
    }
}