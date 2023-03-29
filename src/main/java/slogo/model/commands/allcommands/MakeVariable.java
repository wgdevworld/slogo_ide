package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;
import slogo.model.commands.VarCommand;
import slogo.model.commands.VariableMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MakeVariable extends Commands implements Executable, VarCommand {

    String name;

    double value;

    /**
     * Constructs a new MakeVariable object with default values.
     */
    public MakeVariable() {
        name = "null";
        value = 0;
    }

    /**
     * Constructs a new MakeVariable object with the specified parameters.
     *
     * @param params a list of parameters for the "MakeVariable" command
     */
    public MakeVariable(List<String> params) {
        name = params.get(1);
        value = Double.parseDouble(params.get(0));
    }

    /**
     * Sets the behavior|values of the "MakeVariable" command instance.
     *
     * @param paramsList a list of parameters for the "MakeVariable" command
     * @param turtle     the turtle object
     * @param listStack  the stack of lists
     * @param observers  the list of observers
     * @return the value of the "MakeVariable" command
     */
    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        value = paramsList.get(0);
        VariableMap.variableMap.put(name, value);
        return value;
    }

    /**
     * Executes the "MakeVariable" command.
     *
     * @param turtle the turtle object
     * @return the value of the "MakeVariable" command
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    /**
     * Prepares the "MakeVariable" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {

    }

    /**
     * Sets the variable name of the "MakeVariable" command.
     *
     * @param name the name of the variable to be set
     */
    @Override
    public void setVar(String name) {
        this.name = name;
    }

    /**
     * Stores the variable value in the variable map.
     *
     * @param name  the name of the variable to be stored
     * @param value the value of the variable to be stored
     */
    private void storeValue(String name, double value) {
        VariableMap.variableMap.put(name, value);
    }

    /**
     * Gets the value of the variable from the variable map.
     *
     * @param name the name of the variable to get the value of
     * @return the value of the specified variable
     */
    private double getValue(String name) {
        return VariableMap.variableMap.get(name);
    }
}