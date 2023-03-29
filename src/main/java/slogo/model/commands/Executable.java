package slogo.model.commands;

import slogo.model.Environment;
import slogo.model.Turtle;

public interface Executable {
    double execute(Turtle turtle);
}
