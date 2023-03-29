package slogo.model.commands.allcommands;

import slogo.controller.TurtleObserver;
import slogo.model.Turtle;
import slogo.model.commands.Commands;
import slogo.model.commands.CommandsMap;
import slogo.model.commands.Executable;
import slogo.model.parsers.InputParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MakeUserInstruction extends Commands implements Executable {

    private double value;
    private ArrayList<String> Commands;
    private String name;

    @Override
    public double setBehavior(ArrayList<Double> paramsList, Turtle turtle, Stack<ArrayList<String>> listStack, List<TurtleObserver> observers) throws Exception {

        ArrayList<String> commandsList = listStack.pop();
        commandsList.remove(0);
        ArrayList<String> variablesList = listStack.pop();
        variablesList.set(0, "0");

        InputParser parser = new InputParser(turtle, observers);

        parser.parseTokenizedInput(variablesList);
        CommandsMap.commandsMap.put(name, commandsList);
        return 1;
    }

    /**
     * Executes the "for" command on a turtle.
     * @param turtle the turtle to execute the command on
     * @return the final value of the executed command
     */
    @Override
    public double execute(Turtle turtle) {
        return value;
    }

    /**
     * Prepares the "for" command for execution.
     * @param commandString the string representing the "for" command
     */
    @Override
    public void prep(String commandString) {

    }
}
