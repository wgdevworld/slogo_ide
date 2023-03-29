package slogo.model.commands.allcommands;

import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;

public class IsShowing extends Commands {

    public IsShowing() {}

    public IsShowing(List<String> params) {}

    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle) {
        return turtle.isVisible() ? 1 : 0;
    }

    @Override
    public double execute(Turtle turtle) {
        return turtle.isVisible() ? 1 : 0;
    }
}
