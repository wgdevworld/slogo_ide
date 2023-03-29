package slogo.model.commands.allcommands;

import java.util.ArrayList;
import java.util.List;

import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;

public class Left extends Commands implements Executable {

    private double degrees;

    public Left(){
        degrees = 0;
    }

    public Left(List<String> params) {
        degrees = -1*Double.parseDouble(params.get(0));
    }

    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle) {
        degrees = -1*paramList.get(0);
        return degrees;
    }

    @Override
    public double execute(Turtle turtle) {
        turtle.setDirection(turtle.getDirection() + degrees);
        return Math.abs(degrees);
    }
}
