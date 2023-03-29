/**
 * The NotEqual class represents the "NotEqual?" Boolean Operation.
 * returns 1 if the value of expr1|a and expr2|b are not equal, otherwise 0
 */
package slogo.model.commands.allcommands;

import java.util.ArrayList;
import java.util.List;

import slogo.model.Turtle;
import slogo.model.commands.Commands;

public class NotEqual extends Commands {

    private double a;
    private double b;
    private double value;

    /**
     * Constructs a new NotEqual object with default values.
     */
    public NotEqual() {
        a = 0;
        b = 0;
        value = 0;
    }

    /**
     * Constructs a new NotEqual object with the specified parameters.
     *
     * @param params a list of parameters for the "NotEqual" command
     */
    public NotEqual(List<String> params) {
        a = Double.parseDouble(params.get(0));
        b = Double.parseDouble(params.get(1));
        value = notEqualValue(a, b);
    }

    /**
     * Sets the behavior|values of the "NotEqual" command instance.
     *
     * @param paramList a list of parameters for the "NotEqual" command
     * @param turtle
     * @return the result of the "NotEqual" command
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle) {
        a = paramList.get(0);
        b = paramList.get(1);
        value = notEqualValue(a, b);
        return value;
    }

    /**
     * Executes the "not equal" command.
     *
     * @param turtle the turtle object
     * @return the result of the "NotEqual" command
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    /**
     * Calculates if the first parameter is not equal to the second parameter.
     *
     * @param first the first parameter
     * @param second the second parameter
     * @return 1 if the first value is not equal to the second value
     */
    private double notEqualValue(double first, double second) {
        return first != second ? 1 : 0;
    }
}