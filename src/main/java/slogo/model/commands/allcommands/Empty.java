package slogo.model.commands.allcommands;

import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;

public class Empty extends Commands {
    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle) {
        return 0;
    }

    @Override
    public double execute(Turtle turtle) {
        return 0;
    }
}
