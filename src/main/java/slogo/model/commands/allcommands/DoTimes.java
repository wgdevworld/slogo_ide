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

public class DoTimes extends Commands implements CtrlCommand, Executable {

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

        ArrayList<String> iterationList = (ArrayList<String>) ctrlLists.pop();
        ArrayList<String> commandsStack = (ArrayList<String>) ctrlLists.pop();

        InputParser parser = new InputParser(turtle, observers);

        Stack<Double> paramaterVals = parser.parseTokenizedInput(iterationList);
        Stack<Commands> iterationStack = parser.getCommands();
        Variable variable = (Variable)iterationStack.get(0);
        paramaterVals.pop();
        paramaterVals.pop();
        double limit = paramaterVals.pop();
        variable.setVal(1.0);

        while (variable.getVal() <= limit) {
            value = parser.parseTokenizedInput(commandsStack).peek();
            variable.setVal(variable.getVal() + 1.0);
            //System.out.println("x: " + turtle.getX() + ", y: " + turtle.getY() + ", direction: " + turtle.getDirection() + ", penDown: " + turtle.isPenDown() + ", penColor: " + turtle.getPenColor() + ", visible: " + turtle.isVisible());
        }
        return value;
    }

    @Override
    public int getPops() {
        return 2;
    }
}
