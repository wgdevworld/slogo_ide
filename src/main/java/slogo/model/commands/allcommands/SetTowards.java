package slogo.model.commands.allcommands;

import java.util.ArrayList;
import java.util.List;

import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;

public class SetTowards extends Commands implements Executable {

  private double x;
  private double y;

  public SetTowards() {
    x = 0;
    y = 0;
  }

  public SetTowards(List<String> params) {
    x = Double.parseDouble(params.get(0));
    y = Double.parseDouble(params.get(1));
  }

  @Override
  public double setBehavior(ArrayList<Double> paramsList, Turtle turtle) {
    x = paramsList.get(0);
    y = paramsList.get(1);
    return 1;
  }

  @Override
  public double execute(Turtle turtle) {
    double dx = x - turtle.getX();
    double dy = y - turtle.getY();
    double degrees = Math.atan2(dy, dx);
    turtle.setDirection(turtle.getDirection() + degrees);
    return Math.abs(degrees);
  }
}