package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Random extends Commands {

    private double max;
    private double value;

    public Random() {
        max = 0;
        value = 0;
    }

    public Random(List<String> params) {
        max = Double.parseDouble(params.get(0));
        value = randValue(max);
    }

    /**
     * Sets the behavior|values of the "Random" command instance.
     *
     * @param paramList a list of parameters for the "Random" command
     * @param turtle    the turtle object
     * @param listStack the stack of lists
     * @param observers the list of observers
     * @return a random value between 0 and the specified maximum value
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        max = paramList.get(0);
        value = randValue(max);
        return value;
    }

    /**
     * Executes the "Random" command.
     *
     * @param turtle the turtle object
     * @return a random value between 0 and the specified maximum value
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    /**
     * Prepares the "Random" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }

    private double randValue(double a) {
        return Math.random() * a;
    }
}