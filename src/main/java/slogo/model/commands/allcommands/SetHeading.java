package slogo.model.commands.allcommands;

import java.util.ArrayList;
import java.util.List;

import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.Executable;

public class SetHeading extends Commands implements Executable {

  private double degrees;

  public SetHeading() {
    degrees = 0;
  }

  public SetHeading(List<String> params) {
    degrees = Double.parseDouble(params.get(0));
  }

  @Override
  public double setBehavior(ArrayList<Double> paramsList, Turtle turtle) {
    degrees = paramsList.get(0);
    return degrees;
  }

  @Override
  public double execute(Turtle turtle) {
    double prevDirection = turtle.getDirection();
    turtle.setDirection(degrees);
    return Math.min(Math.abs(prevDirection - degrees), 360 - Math.abs(prevDirection - degrees)); //TODO: Test if this works
  }
}
