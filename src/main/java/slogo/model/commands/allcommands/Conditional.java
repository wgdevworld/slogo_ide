package slogo.model.commands.allcommands;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import slogo.model.Turtle;
import slogo.model.commands.Commands;
import java.util.ArrayList;
import slogo.model.commands.allcommands.ListEnd;
import slogo.model.commands.allcommands.ListStart;

public class Conditional extends Commands {


  private boolean evaluate;
  private Queue<Commands> trueCommands;
  private Queue<Commands> falseCommands;
  private boolean addTrue;
  private boolean continueIf;
  private double returnVal;

  public Conditional () {
    trueCommands = new LinkedList<>();
    falseCommands = new LinkedList<>();
    continueIf = true;
    addTrue = true;
    returnVal = 0.0;
  }

  public void evaluateBoolean (Commands boolStatement, Turtle turtle) {
    double boolVal =  boolStatement.execute(turtle);
    evaluate = (1 == boolVal);
  }

  public Stack<Commands> setConditions (Stack<Commands> conditionStack) {
    while (continueIf) {
      Commands cmd = conditionStack.pop();
      continueIf = !(cmd instanceof ListEnd &&
          (conditionStack.isEmpty() || !(conditionStack.peek() instanceof ListStart)));

      if (addTrue) {
        trueCommands.add(cmd);
      } else {
        falseCommands.add(cmd);
      }
      addTrue = (!(cmd instanceof ListEnd) && falseCommands.isEmpty());

    }
    return conditionStack;
  }

  @Override
  public double setBehavior(ArrayList<Double> parameters, Turtle turtle) {
    return 0;
  }

  @Override
  public double execute(Turtle turtle) {
    if (evaluate) {
      while (!trueCommands.isEmpty()) {
        Commands cmd = trueCommands.remove();
        if (!(cmd instanceof ListEnd)) {
          returnVal = cmd.execute(turtle);
        }
      }
    } else {
      while (!falseCommands.isEmpty()) {
        Commands cmd = falseCommands.remove();
        if (!(cmd instanceof ListEnd)) {
          returnVal = cmd.execute(turtle);
        }
      }
    }
    return returnVal;
  }
}