package slogo.model.commands.allcommands;

import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;

import java.util.ArrayList;
import java.util.List;

public class ShowTurtle extends Commands implements Executable {

    public ShowTurtle() {}

    public ShowTurtle(List<String> params) {}

    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle) {
        return 1;
    }

    @Override
    public double execute(Turtle turtle) {
        turtle.setVisibility(true);
        return turtle.isVisible() ? 1 : 0;
    }
}
