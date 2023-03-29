package slogo.model.commands.allcommands;

import java.util.ArrayList;
import java.util.List;

import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;

public class Forward extends Commands implements Executable {
    private double distance;

    public Forward() {
        distance = 0;
    }

    public Forward(List<String> params) {
        distance = Integer.parseInt(params.get(0));
    }

    @Override
    public double setBehavior(ArrayList<Double> paramList, Turtle turtle) {
        distance = paramList.get(0);
        return distance;
    }

    @Override
    public double execute(Turtle turtle) {
        double angle = Math.toRadians(turtle.getDirection());
        double dx = Math.cos(angle) * distance;
        double dy = Math.sin(angle) * distance;
        turtle.setPosition(turtle.getX() + dx, turtle.getY() + dy);
        return Math.abs(distance);
    }
}
