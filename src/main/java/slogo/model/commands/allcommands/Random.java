package slogo.model.commands.allcommands;

import java.util.ArrayList;
import java.util.List;

import slogo.model.Turtle;
import slogo.model.commands.Commands;

public class Random extends Commands {

  private double max;
  private double value;

  public Random() {
    max = 0;
    value = 0;
  }

  public Random(List<String> params) {
    max = Double.parseDouble(params.get(0));
    value = randValue(max);
  }

  @Override
  public double setBehavior(ArrayList<Double> paramList, Turtle turtle) {
    max = paramList.get(0);
    value = randValue(max);
    return value;
  }

  @Override
  public double execute(Turtle turtle) {
    return value;
  }

  private double randValue(double a) {
    return Math.random() * a;
  }
}
