package slogo.model.commands.allcommands;

import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;

import java.util.ArrayList;
import java.util.List;

public class Heading extends Commands implements Executable {

    public Heading() {}

    public Heading(List<String> params) {}

    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle) {
        return 1;
    }

    @Override
    public double execute(Turtle turtle) {
        return turtle.getDirection();
    }
}
