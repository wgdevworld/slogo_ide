package slogo.model.commands.allcommands;

import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;

import java.util.ArrayList;
import java.util.List;

public class ClearScreen extends Commands implements Executable {

    public ClearScreen() {}

    public ClearScreen(List<String> params) {}

    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle) {
        return 1;
    }

    @Override
    public double execute(Turtle turtle) {
        final double coordinate = 0;
        double distance = Math.hypot(turtle.getX() - coordinate, turtle.getY() - coordinate);
        turtle.clearScreen();
        return distance;
    }
}
