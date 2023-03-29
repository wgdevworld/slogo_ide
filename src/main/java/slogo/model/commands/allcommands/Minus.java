package slogo.model.commands.allcommands;

import java.util.ArrayList;
import java.util.List;

import slogo.model.Turtle;
import slogo.model.commands.Commands;

public class Minus extends Commands {

    private double a;
    private double value;

    public Minus() {
        a = 0;
        value = 0;
    }

    public Minus(List<String> params) {
        a = Double.parseDouble(params.get(0));
        value = minusValue(a);
    }

    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle) {
        a = paramList.get(0);
        value = minusValue(a);
        return value;
    }
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    private double minusValue(double first) {
        return -first;
    }
}
