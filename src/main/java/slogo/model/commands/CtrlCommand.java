package slogo.model.commands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public interface CtrlCommand {

    public double setBehavior(Stack<List<String>> ctrlLists, ArrayList<Double> paramList, Turtle turtle, List<TurtleObserver> observers) throws Exception;

    public int getPops();
}
