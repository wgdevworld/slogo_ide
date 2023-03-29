package slogo.model.commands.allcommands;

import java.util.ArrayList;
import java.util.List;

import slogo.model.Turtle;
import slogo.model.commands.Commands;

public class Power extends Commands {

    private double base;
    private double exponent;
    private double value;

    public Power() {
        base = 0;
        exponent = 0;
        value = 0;
    }

    public Power(List<String> params) {
        base = Double.parseDouble(params.get(0));
        exponent = Double.parseDouble(params.get(1));
        value = powValue(base, exponent);
    }

    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle) {
        base = paramList.get(0);
        exponent = paramList.get(1);
        value = powValue(base, exponent);
        return value;
    }
    @Override
    public double execute(Turtle turtle) {
        return value;
    }
    private double powValue(double a, double b) {
        return Math.pow(a, b);
    }
}
