package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.VariableMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Variable extends Commands {

    private double value;
    private String name;

    /**
     * Constructs a new Variable object with default values.
     */
    public Variable() {
        value = 0;
        name = "null";
    }

    /**
     * Constructs a new Variable object with the specified parameters.
     *
     * @param params a list of parameters for the "Variable" command
     */
    public Variable(List<String> params) {
        name = params.get(1);
        value = Double.parseDouble(params.get(0));
    }

    /**
     * Sets the behavior|values of the "Variable" command instance.
     *
     * @param paramsList a list of parameters for the "Variable" command
     * @param turtle     the turtle object
     * @param listStack  the stack of lists
     * @param observers  the list of observers
     * @return the value of the "Variable" command
     */
    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) {
        value = VariableMap.variableMap.get(name);
        return value;
    }

    /**
     * Executes the "Variable" command.
     *
     * @param turtle the turtle object
     * @return the value of the "Variable" command
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    /**
     * Prepares the "Variable" command.
     *
     * @param commandString the string representation of the command
     */
    @Override
    public void prep(String commandString) {
        String name = commandString.split("\\|")[0].trim().split(":")[1].trim();
        set(name);
    }

    /**
     * Sets the name of the variable and initializes its value if it doesn't exist in the variable map.
     *
     * @param name the name of the variable
     */
    public void set(String name) {
        this.name = name;
        if (!VariableMap.variableMap.containsKey(name)) {
            VariableMap.variableMap.put(name, 0.0);
        }
    }

    /**
     * Gets the value of the variable from the variable map.
     *
     * @return the value of the variable
     */
    public double getVal() {
        if (VariableMap.variableMap.containsKey(name)) {
            return VariableMap.variableMap.get(name);
        }
        return 0;
    }

    /**
     * Sets the value of the variable in the variable map and updates the value variable.
     *
     * @param val the value of the variable
     */
    public void setVal(double val) {
        VariableMap.variableMap.put(name, val);
        value = val;
    }

    /**
     * Gets the name of the variable.
     *
     * @return the name of the variable
     */
    public String getName() {
        return name;
    }
}