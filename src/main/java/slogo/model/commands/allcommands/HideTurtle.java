package slogo.model.commands.allcommands;

import slogo.model.Environment;
import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;

import java.util.ArrayList;
import java.util.List;

public class HideTurtle extends Commands implements Executable {

    public HideTurtle() {}

    public HideTurtle(List<String> params) {}

    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle) {
        return 0;
    }

    @Override
    public double execute(Turtle turtle) {
        turtle.setVisibility(false);
        return turtle.isVisible() ? 1 : 0;
    }
}
