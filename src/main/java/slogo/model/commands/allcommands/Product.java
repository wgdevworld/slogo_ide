package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Product extends Commands {

    private double a;
    private double b;
    private double value;

    public Product() {
        a = 0;
        b = 0;
        value = 0;
    }

    public Product(List<String> params) {
        a = Double.parseDouble(params.get(0));
        b = Double.parseDouble(params.get(1));
        value = prodValue(a, b);
    }

    /**
     * Sets the behavior|values of the "Product" command instance.
     *
     * @param paramList a list of parameters for the "Product" command
     * @param turtle    the turtle object
     * @param listStack the stack of lists
     * @param observers the list of observers
     * @return the product of the two values
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        a = paramList.get(0);
        b = paramList.get(1);
        value = prodValue(a, b);
        return value;
    }

    /**
     * Executes the "Product" command.
     *
     * @param turtle the turtle object
     * @return the product of the two values
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    /**
     * Prepares the "Product" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }

    private Double prodValue(double first, double second) {
        return first * second;
    }
}