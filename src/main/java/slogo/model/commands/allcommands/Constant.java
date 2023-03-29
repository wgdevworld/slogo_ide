package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * The Constant class represents a constant value in Slogo.
 */
public class Constant extends Commands {

    private double number;

    /**
     * Constructs a new Constant object with a default value of 0.
     */
    public Constant() {
        number = 0;
    }

    /**
     * Constructs a new Constant object with the specified parameters.
     *
     * @param params a list of parameters for the Constant command
     */
    public Constant(List<String> params) {
        number = Double.parseDouble(params.get(0));
    }

    /**
     * Sets the value of the Constant object.
     *
     * @param value the new value for the Constant
     */
    public void set(Double value) {
        number = value;
    }

    /**
     * Sets the behavior|values of the Constant object.
     *
     * @param paramList a list of parameters for the Constant command
     * @param turtle    the turtle object
     * @param listStack the stack of lists
     * @param observers the list of turtle observers
     * @return the value of the Constant
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        return number;
    }

    /**
     * Executes the Constant command.
     *
     * @param turtle the turtle object
     * @return the value of the Constant
     */
    @Override
    public double execute(Turtle turtle) {
        return number;
    }

    /**
     * Parses the commandString to set the value of the Constant object.
     *
     * @param commandString the string representation of the Constant command
     */
    @Override
    public void prep(String commandString) {
        Double Constant = Double.parseDouble(commandString.split("\\|")[0].trim());
        set(Constant);
    }
}