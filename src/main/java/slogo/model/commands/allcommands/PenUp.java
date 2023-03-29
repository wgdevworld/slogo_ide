package slogo.model.commands.allcommands;

import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;

import java.util.ArrayList;
import java.util.List;

public class PenUp extends Commands implements Executable {

    public PenUp() {}

    public PenUp(List<String> params) {}

    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle) {
        return 1;
    }

    @Override
    public double execute(Turtle turtle) {
        turtle.setPenDown(false);
        return turtle.isPenDown() ? 1 : 0;
    }
}
