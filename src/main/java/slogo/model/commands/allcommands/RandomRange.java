package slogo.model.commands.allcommands;

import java.util.ArrayList;
import java.util.List;

import slogo.model.Turtle;
import slogo.model.commands.Commands;

public class RandomRange extends Commands {

    private double min;
    private double max;
    private double value;

    public RandomRange() {
        min = 0;
        max = 0;
        value = 0;
    }

    public RandomRange(List<String> params) {
        max = Double.parseDouble(params.get(0));
        value = randValue(min, max);
    }

    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle) {
        min = paramList.get(0);
        max = paramList.get(1);
        value = randValue(min, max);
        return value;
    }

    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    private double randValue(double a, double b) {
        return Math.random() * (b - a + 1) + a;
    }
}
