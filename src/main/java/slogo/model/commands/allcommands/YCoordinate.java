package slogo.model.commands.allcommands;

import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;

public class YCoordinate extends Commands {

    public YCoordinate() {}

    public YCoordinate(ArrayList<String> params) {}

    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle) {return turtle.getY();}

    @Override
    public double execute(Turtle turtle) {return turtle.getY();}
}
