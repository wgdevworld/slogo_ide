/**
 * The And class represents the "And" Boolean Operation.
 * returns 1 if a and b are non-zero, otherwise 0
 */
package slogo.model.commands.allcommands;

import java.util.ArrayList;
import java.util.List;

import slogo.model.Turtle;
import slogo.model.commands.Commands;

public class And extends Commands {

    private double a;
    private double b;
    private double value;

    /**
     * Constructs a new And object with default values.
     */
    public And() {
        a = 0;
        b = 0;
        value = 0;
    }

    /**
     * Constructs a new And object with the specified parameters.
     *
     * @param params a list of parameters for the "And" command
     */
    public And(List<String> params) {
        a = Double.parseDouble(params.get(0));
        b = Double.parseDouble(params.get(1));
        value = andValue(a, b);
    }

    /**
     * Sets the behavior|values of the "And" command instance.
     *
     * @param paramList a list of parameters for the "And" command
     * @param turtle
     * @return the result of the "And" command
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle) {
        a = paramList.get(0);
        b = paramList.get(1);
        value = andValue(a, b);
        return value;
    }

    /**
     * Executes the "and" command.
     *
     * @param turtle the turtle object
     * @return the result of the "And" command
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    /**
     * Calculates if both first and second are non-zero.
     *
     * @param first the first test value
     * @param second the second test value
     * @return 1 if both first and second are non-zero
     */
    private double andValue(double first, double second) {
        return (first != 0 && second != 0) ? 1 : 0;
    }
}