package slogo.model.commands.allcommands;

import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.VariableMap;

import java.util.ArrayList;
import java.util.List;

public class Variable extends Commands {

    private double value;
    private String name;

    public Variable() {
        value = 0;
        name = "null";
    }

    public Variable(List<String> params) {
        name = params.get(1);
        value = Double.parseDouble(params.get(0));
    }

    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle) {
        value = VariableMap.variableMap.get(name);
        return value;
    }

    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    public void set(String name) {
        this.name = name;
        if (!VariableMap.variableMap.containsKey(name)) {
            VariableMap.variableMap.put(name, 0.0);
        }
    }

    public void setVal(double val) {
        VariableMap.variableMap.put(name, val);
        value = val;
    }

    public double getVal() {
        if (VariableMap.variableMap.containsKey(name)) {
            return VariableMap.variableMap.get(name);
        }
        return 0;
    }

    public String getName(){return name;}
}