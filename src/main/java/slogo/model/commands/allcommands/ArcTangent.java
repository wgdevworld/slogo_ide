package slogo.model.commands.allcommands;

import java.util.ArrayList;
import java.util.List;

import slogo.model.Turtle;
import slogo.model.commands.Commands;

public class ArcTangent extends Commands {

    private double degrees;
    private double value;

    public ArcTangent() {
        degrees = 0;
        value = 0;
    }

    public ArcTangent(List<String> params) {
        degrees = Double.parseDouble(params.get(0));
        value = atanValue(degrees);
    }

    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle) {
        degrees = paramList.get(0);
        value = atanValue(degrees);
        return value;
    }
    @Override
    public double execute(Turtle turtle) {
        return value;
    }
    private double atanValue(double a) {
        double radians = a * Math.PI / 180;
        return Math.atan(radians);
    }
}
