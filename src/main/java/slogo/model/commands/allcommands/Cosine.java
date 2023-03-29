package slogo.model.commands.allcommands;

import java.util.ArrayList;
import java.util.List;

import slogo.model.Turtle;
import slogo.model.commands.Commands;

public class Cosine extends Commands {

    private double degrees;
    private double value;

    public Cosine() {
        degrees = 0;
        value = 1;
    }

    public Cosine(List<String> params) {
        degrees = Double.parseDouble(params.get(0));
        value = cosValue(degrees);
    }

    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle) {
        degrees = paramList.get(0);
        value = cosValue(degrees);
        return value;
    }
    @Override
    public double execute(Turtle turtle) {
        return value;
    }
    private double cosValue (double a) {
        double radians = a * Math.PI / 180;
        return Math.cos(radians);
    }
}
