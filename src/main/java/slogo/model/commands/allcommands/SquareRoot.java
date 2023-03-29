package slogo.model.commands.allcommands;

import java.util.ArrayList;
import java.util.List;

import slogo.model.Turtle;
import slogo.model.commands.Commands;

public class SquareRoot extends Commands {

    private double a;
    private double value;

    public SquareRoot() {
        a = 0;
        value = 0;
    }

    public SquareRoot(List<String> params) {
        a = Double.parseDouble(params.get(0));
        value = sqrtValue(a);
    }

    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle) {
        a = paramList.get(0);
        value = sqrtValue(a);
        return value;
    }
    @Override
    public double execute(Turtle turtle) {
        return value;
    }
    private double sqrtValue(double a) {
        return Math.sqrt(a);
    }
}
