package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.CtrlCommand;
import slogo.model.commands.Executable;
import slogo.model.parsers.InputParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Repeat extends Commands implements CtrlCommand, Executable {

    private double value;

    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle) {
        return value;
    }

    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    @Override
    public double setBehavior(Stack<List<String>> ctrlLists, ArrayList<Double> paramList, Turtle turtle, List<TurtleObserver> observers) throws Exception{

        ArrayList<String> commandsStack = (ArrayList<String>) ctrlLists.pop();
        InputParser parser = new InputParser(turtle, observers);
        double times = paramList.get(0);

        for (int i = 0; i < times; i++) {
            value = parser.parseTokenizedInput(commandsStack).peek();
            //System.out.println("x: " + turtle.getX() + ", y: " + turtle.getY() + ", direction: " + turtle.getDirection() + ", penDown: " + turtle.isPenDown() + ", penColor: " + turtle.getPenColor() + ", visible: " + turtle.isVisible());
        }
        return value;
    }

    @Override
    public int getPops() {
        return 1;
    }
}
