package slogo.model.commands;

import slogo.model.Turtle;

public interface Executable {

    /**
     * Executes the command with the given turtle object.
     * Used to denote which commands change the values of turtle or the values of variables. This means we can make sure everything is updated behind them before they update.
     *
     * @param turtle the turtle object
     * @return the result of executing the command
     */
    double execute(Turtle turtle);
}