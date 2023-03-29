/**
 * The LessEqual class represents the "LessEqual?" Boolean Operation.
 * returns 1 if the value of expr1|a is less than or equal to the value of expr2|b, otherwise 0
 */
package slogo.model.commands.allcommands;

import java.util.ArrayList;
import java.util.List;

import slogo.model.Turtle;
import slogo.model.commands.Commands;

public class LessEqual extends Commands {

    private double a;
    private double b;
    private double value;

    /**
     * Constructs a new LessEqual object with default values.
     */
    public LessEqual() {
        a = 0;
        b = 0;
        value = 0;
    }

    /**
     * Constructs a new LessEqual object with the specified parameters.
     *
     * @param params a list of parameters for the "LessEqual" command
     */
    public LessEqual(List<String> params) {
        a = Double.parseDouble(params.get(0));
        b = Double.parseDouble(params.get(1));
        value = lessEqualValue(a, b);
    }

    /**
     * Sets the behavior|values of the "LessEqual" command instance.
     *
     * @param paramList a list of parameters for the "LessEqual" command
     * @param turtle
     * @return the result of the "LessEqual" command
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle) {
        a = paramList.get(0);
        b = paramList.get(1);
        value = lessEqualValue(a, b);
        return value;
    }

    /**
     * Executes the "less than or equal" command.
     *
     * @param turtle the turtle object
     * @return the result of the "LessEqual" command
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    /**
     * Calculates if the first parameter is less than or equal to the second parameter and returns a boolean value accordingly.
     *
     * @param first the first parameter
     * @param second the second parameter
     * @return 1 if the first value is less than or equal to the second value
     */
    private double lessEqualValue(double first, double second) {
        return first <= second ? 1 : 0;
    }
}