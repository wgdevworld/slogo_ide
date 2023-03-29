package slogo.model.commands.allcommands;

import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;
import slogo.model.commands.VarCommand;
import slogo.model.commands.VariableMap;

import java.util.ArrayList;
import java.util.List;

public class MakeVariable extends Commands implements Executable, VarCommand {

    String name;

    double value;

    public MakeVariable() {
        name = "null";
        value = 0;
    }

    public MakeVariable(List<String> params) {
        name = params.get(1);
        value = Double.parseDouble(params.get(0));
    }

    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle) {
        value = paramsList.get(1);
        VariableMap.variableMap.put(name, value);
        return value;
    }

    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    @Override
    public void setVar(String name) {
        this.name = name;
    }

    private void storeValue(String name, double value) {
        VariableMap.variableMap.put(name, value);
    }

    private double getValue(String name) {
        return VariableMap.variableMap.get(name);
    }
}
