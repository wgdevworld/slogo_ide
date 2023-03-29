
package slogo.model.commands.allcommands;

import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;

import java.util.ArrayList;
import java.util.List;

public class PenDown extends Commands implements Executable {

    public PenDown() {}

    public PenDown(List<String> params) {}

    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle) {
        return 1;
    }

    @Override
    public double execute(Turtle turtle) {
        turtle.setPenDown(true);
        return turtle.isPenDown() ? 1 : 0;
    }
}


