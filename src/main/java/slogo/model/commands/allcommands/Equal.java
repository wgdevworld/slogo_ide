/**
 * The Equal class represents the "Equal?" Boolean Operation.
 * returns 1 if the value of expr1|a and expr2|b are equal, otherwise 0
 */
package slogo.model.commands.allcommands;

import java.util.ArrayList;
import java.util.List;

import slogo.model.Turtle;
import slogo.model.commands.Commands;

public class Equal extends Commands {

    private double a;
    private double b;
    private double value;

    /**
     * Constructs a new Equal object with default values.
     */
    public Equal() {
        a = 0;
        b = 0;
        value = 0;
    }

    /**
     * Constructs a new Equal object with the specified parameters.
     *
     * @param params a list of parameters for the "Equal" command
     */
    public Equal(List<String> params) {
        a = Double.parseDouble(params.get(0));
        b = Double.parseDouble(params.get(1));
        value = equalValue(a, b);
    }

    /**
     * Sets the behavior|values of the "Equal" command instance.
     *
     * @param paramList a list of parameters for the "Equal" command
     * @param turtle
     * @return the result of the "Equal" command
     */
    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle) {
        a = paramList.get(0);
        b = paramList.get(1);
        value = equalValue(a, b);
        return value;
    }

    /**
     * Executes the "equal" command.
     *
     * @param turtle the turtle object
     * @return the result of the "Equal" command
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    /**
     * Calculates if the first parameter is equal to the second parameter.
     *
     * @param first the first parameter
     * @param second the second parameter
     * @return 1 if the first value is equal to the second value
     */
    private double equalValue(double first, double second) {
        return first == second ? 1 : 0;
    }
}