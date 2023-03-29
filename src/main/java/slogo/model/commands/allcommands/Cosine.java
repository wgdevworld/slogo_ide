package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Cosine extends Commands {

    private double degrees;
    private double value;

    /**
     * Constructs a new Cosine object with default values.
     */
    public Cosine() {
        degrees = 0;
        value = 1;
    }

    /**
     * Constructs a new Cosine object with the specified parameters.
     *
     * @param params a list of parameters for the "Cosine" command
     */
    public Cosine(List<String> params) {
        degrees = Double.parseDouble(params.get(0));
        value = cosValue(degrees);
    }

    /**
     * Sets the behavior|values of the "Cosine" command instance.
     *
     * @param paramList a list of parameters for the "Cosine" command
     * @param turtle    the turtle object
     * @param listStack the stack of lists
     * @param observers the list of observers
     * @return the result of the "Cosine" command
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        degrees = paramList.get(0);
        value = cosValue(degrees);
        return value;
    }

    /**
     * Executes the "Cosine" command.
     *
     * @param turtle the turtle object
     * @return the result of the "Cosine" command
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    /**
     * Prepares the "Cosine" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }

    /**
     * Calculates the cosine of the input angle in degrees.
     *
     * @param a the angle in degrees
     * @return the cosine of the input angle
     */
    private double cosValue(double a) {
        double radians = a * Math.PI / 180;
        return Math.cos(radians);
    }
}
