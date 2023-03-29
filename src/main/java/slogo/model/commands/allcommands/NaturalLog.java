package slogo.model.commands.allcommands;

import java.util.ArrayList;
import java.util.List;

import slogo.model.Turtle;
import slogo.model.commands.Commands;

public class NaturalLog extends Commands {

    private double a;
    private double value;

    public NaturalLog() {
        a = 1;
        value = 0;
    }

    public NaturalLog(List<String> params) {
        a = Double.parseDouble(params.get(0));
        value = logValue(a);
    }

    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle) {
        a = paramList.get(0);
        value = logValue(a);
        return value;
    }
    @Override
    public double execute(Turtle turtle) {
        return value;
    }
    private double logValue(double a) {
        return Math.log(a);
    }
}
