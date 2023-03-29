package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ArcTangent extends Commands {

    private double degrees;
    private double value;

    /**
     * Constructs a new ArcTangent object with default values.
     */
    public ArcTangent() {
        degrees = 0;
        value = 0;
    }

    /**
     * Constructs a new ArcTangent object with the specified parameters.
     *
     * @param params a list of parameters for the "ArcTangent" command
     */
    public ArcTangent(List<String> params) {
        degrees = Double.parseDouble(params.get(0));
        value = atanValue(degrees);
    }

    /**
     * Sets the behavior|values of the "ArcTangent" command instance.
     *
     * @param paramList a list of parameters for the "ArcTangent" command
     * @param turtle
     * @param listStack
     * @param observers
     * @return the result of the "ArcTangent" command
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        degrees = paramList.get(0);
        value = atanValue(degrees);
        return value;
    }

    /**
     * Executes the "Arctangent" command.
     *
     * @param turtle the turtle object
     * @return the result of the "Arctangent" command
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    @Override
    public void prep(String commandString) {

    }

    /**
     * Calculates arctangent of the given degrees.
     *
     * @param a the degrees to calculate arctangent of
     * @return the arctangent of the given degrees
     */
    private double atanValue(double a) {
        double radians = a * Math.PI / 180;
        return Math.atan(radians);
    }
}
