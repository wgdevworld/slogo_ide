package slogo.model.commands.allcommands;

import java.util.ArrayList;
import java.util.List;

import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;

public class SetPosition extends Commands implements Executable {
  private double x;
  private double y;

  public SetPosition() {
    x = 0;
    y = 0;
  }

  public SetPosition(List<String> params) {
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
    double distance = Math.hypot(turtle.getX() - x, turtle.getY() - y);
    turtle.setPosition(x, (-1 * y));
    return Math.abs(distance);
  }
}
