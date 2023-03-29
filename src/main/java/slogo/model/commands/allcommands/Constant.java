package slogo.model.commands.allcommands;

import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;

public class Constant extends Commands {

    private double number;
    public Constant () {number = 0;}

    public Constant(List<String> params) {
        number = Double.parseDouble(params.get(0));
    }

    public void set(Double value) {
        number = value;
    }
    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle) {
        return number;
    }

    @Override
    public double execute(Turtle turtle) {
        return number;
    }
}
