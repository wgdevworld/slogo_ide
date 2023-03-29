package slogo.model.commands.allcommands;

import slogo.model.Turtle;
import slogo.model.commands.Commands;

import java.util.ArrayList;

public class XCoordinate extends Commands {

    public XCoordinate() {}

    public XCoordinate(ArrayList<String> params) {}

    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle) {
        return turtle.getX();
    }

    @Override
    public double execute(Turtle turtle) {return turtle.getX();}
}
