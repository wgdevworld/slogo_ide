package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tangent extends Commands {

    private double degrees;
    private double value;

    /**
     * Constructs a new Tangent object with default values.
     */
    public Tangent() {
        degrees = 0;
        value = 0;
    }

    /**
     * Constructs a new Tangent object with the specified parameters.
     *
     * @param params a list of parameters for the "Tangent" command
     */
    public Tangent(List<String> params) {
        degrees = Double.parseDouble(params.get(0));
        value = tanValue(degrees);
    }

    /**
     * Sets the behavior|values of the "Tangent" command instance.
     *
     * @param paramList a list of parameters for the "Tangent" command
     * @param turtle    the turtle object
     * @param listStack the stack of lists
     * @param observers the list of observers
     * @return the value of the "Tangent" command
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        degrees = paramList.get(0);
        value = tanValue(degrees);
        return value;
    }

    /**
     * Executes the "Tangent" command.
     *
     * @param turtle the turtle object
     * @return the value of the "Tangent" command
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    /**
     * Prepares the "Tangent" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }

    /**
     * Computes the tangent value of the given angle in degrees.
     *
     * @param a the angle in degrees
     * @return the tangent value of the given angle
     */
    private double tanValue(double a) {
        double radians = a * Math.PI / 180;
        return Math.tan(radians);
    }
}