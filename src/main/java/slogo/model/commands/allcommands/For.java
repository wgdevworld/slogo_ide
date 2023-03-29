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

public class For extends Commands implements CtrlCommand, Executable {

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
        double start = paramaterVals.pop();
        variable.setVal(start);
        double end = paramaterVals.pop();
        double increment = paramaterVals.pop();


        while (variable.getVal() < end) {
            value = parser.parseTokenizedInput(commandsStack).peek();
            variable.setVal(variable.getVal() + increment);
        }
        return value;
    }

    @Override
    public int getPops() {
        return 2;
    }
}
