package slogo.model.commands;

import java.util.ArrayList;

import slogo.model.Turtle;

public abstract class Commands {
  public Commands() {}

  public abstract double setBehavior(ArrayList<Double> paramsList, Turtle turtle);

  public abstract double execute(Turtle turtle);

}
