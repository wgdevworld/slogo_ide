package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Sine extends Commands {

    private double degrees;

    private double value;

    /**
     * Constructs a new Sine object with default values.
     */
    public Sine() {
        degrees = 0;
        value = 0;
    }

    /**
     * Constructs a new Sine object with the specified parameters.
     *
     * @param params a list of parameters for the "Sine" command
     */
    public Sine(List<String> params) {
        degrees = Double.parseDouble(params.get(0));
        value = sinValue(degrees);
    }

    /**
     * Sets the behavior|values of the "Sine" command instance.
     *
     * @param paramList a list of parameters for the "Sine" command
     * @param turtle    the turtle object
     * @param listStack the stack of lists
     * @param observers the list of observers
     * @return the sine value of the specified angle in degrees
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        degrees = paramList.get(0);
        value = sinValue(degrees);
        return value;
    }

    /**
     * Executes the "Sine" command.
     *
     * @param turtle the turtle object
     * @return the sine value of the specified angle in degrees
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    /**
     * Prepares the "Sine" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }

    private double sinValue(double a) {
        double radians = a * Math.PI / 180;
        return Math.sin(radians);
    }
}
