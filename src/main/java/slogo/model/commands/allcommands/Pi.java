package slogo.model.commands.allcommands;

import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;

public class Pi extends Commands {

    public Pi() {}

    public Pi(List<String> params) {}

    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle) {
        return Math.PI;
    }

    @Override
    public double execute(Turtle turtle) {
        return Math.PI;
    }
}
