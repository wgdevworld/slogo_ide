package slogo.model.commands.allcommands;

import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;

public class IsPenDown extends Commands {

    public IsPenDown() {}

    public IsPenDown(List<String> params) {}

    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle) {
        return turtle.isPenDown() ? 1 : 0;
    }

    @Override
    public double execute(Turtle turtle) {
        return turtle.isPenDown() ? 1 : 0;
    }
}
