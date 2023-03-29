public class SLogoController implements Controller {

  private Model model;
  private View view;

  public SLogoController(Model model, View view) {
    this.model = model;
    this.view = view;
  }

  // The user types 'fd 50' in the command window, and sees the turtle move in the display window
  // leaving a trail, and the command is added to the environment's history.
  // The user types '50 fd' in the command window and sees an error message that the command was
  // not formatted correctly.

  public void handleCommand(String command) {
    try {
      // Parse command and execute
      Command cmd = parseCommand(command);
      cmd.execute();
      model.addCommand(command);

      // Update view
      view.displayCommands(model.getCommands());
      view.displayVariables(model.getVariables());
    } catch (Exception e) {
      view.displayError(e.getMessage());
    }
  }

  // The user sets a variable's value and sees it updated in the UI's Variable view.

  public void handleVariableAssignment(String variable, double value) {
    // Set the variable value in the model
    model.setVariable(variable, value);

    // Update the variable view in the UI
    view.displayVariables(model.getVariables());
  }

  public void handleClear() {
    // Clear the model and update the view
    model.clear();
    view.displayCommands(model.getCommands());
    view.displayVariables(model.getVariables());
  }

  //The user sets the pen's color using the UI so subsequent lines drawn when the turtle
  //moves use that color.

  public void handlePenColor(Color color) {
    // Set the pen color in the model
    model.setPenColor(color);

    // Update the pen color view in the UI
    view.displayPenColor(model.getPenColor());
  }

  // The user types 'repeat 4 [ fd 50 rt 90 ]' in the command window and sees the turtle move in a
  // square pattern, and the command is added to the environment's history.

  public void handleCommand(String command) {
    try {
      // Parse command and execute
      Command cmd = parseCommand(command);
      if (cmd instanceof RepeatCommand) {
        RepeatCommand repeatCmd = (RepeatCommand) cmd;
        for (int i = 0; i < repeatCmd.getRepeatCount(); i++) {
          repeatCmd.execute();
        }
      } else {
        cmd.execute();
      }
      model.addCommand(command);

      // Update view
      view.displayCommands(model.getCommands());
      view.displayVariables(model.getVariables());
    } catch (Exception e) {
      view.displayError(e.getMessage());
    }
  }

  // The user types 'set :radius 50' in the command window and sees the value of the :radius variable
  // updated in the UI's Variable view.

  public void handleCommand(String command) {
    try {
      // Parse command and execute
      Command cmd = parseCommand(command);
      if (cmd instanceof VariableAssignmentCommand) {
        VariableAssignmentCommand varCmd = (VariableAssignmentCommand) cmd;
        model.setVariable(varCmd.getVariableName(), varCmd.getValue());
      } else {
        cmd.execute();
      }
      model.addCommand(command);

      // Update view
      view.displayCommands(model.getCommands());
      view.displayVariables(model.getVariables());
    } catch (Exception e) {
      view.displayError(e.getMessage());
    }
  }

  // The user types 'home' in the command window and sees the turtle return to the center of the
  // display window.

  public void handleCommand(String command) {
    try {
      // Parse command and execute
      Command cmd = parseCommand(command);
      if (cmd instanceof HomeCommand) {
        HomeCommand homeCmd = (HomeCommand) cmd;
        homeCmd.execute();
      } else {
        cmd.execute();
      }
      model.addCommand(command);

      // Update view
      view.displayCommands(model.getCommands());
      view.displayVariables(model.getVariables());
    } catch (Exception e) {
      view.displayError(e.getMessage());
    }
  }

  // The user types 'cs' in the command window and sees the display window cleared of all lines.

  public void handleCommand(String command) {
    try {
      // Parse command and execute
      Command cmd = parseCommand(command);
      if (cmd instanceof ClearScreenCommand) {
        ClearScreenCommand clearCmd = (ClearScreenCommand) cmd;
        clearCmd.execute();
      } else {
        cmd.execute();
      }
      model.addCommand(command);

      // Update view
      view.displayCommands(model.getCommands());
      view.displayVariables(model.getVariables());
    } catch (Exception e) {
      view.displayError(e.getMessage());
    }
  }

  // The user types 'setpencolor 255 0 0' in the command window and sees the color of the pen changed to red.

  public void handleCommand(String command) {
    try {
      // Parse command and execute
      Command cmd = parseCommand(command);
      if (cmd instanceof SetPenColorCommand) {
        SetPenColorCommand colorCmd = (SetPenColorCommand) cmd;
        colorCmd.execute();
      } else {
        cmd.execute();
      }
      model.addCommand(command);

      // Update view
      view.displayCommands(model.getCommands());
      view.displayVariables(model.getVariables());
    } catch (Exception e) {
      view.displayError(e.getMessage());
    }
  }

  // The user types 'pd' in the command window and sees the pen lowered so that subsequent movements
  // of the turtle leave a trail.

  public void handleCommand(String command) {
    try {
      // Parse command and execute
      Command cmd = parseCommand(command);
      if (cmd instanceof PenDownCommand) {
        PenDownCommand pdCmd = (PenDownCommand) cmd;
        pdCmd.execute();
      } else {
        cmd.execute();
      }
      model.addCommand(command);

      // Update view
      view.displayCommands(model.getCommands());
      view.displayVariables(model.getVariables());
    } catch (Exception e) {
      view.displayError(e.getMessage());
    }
  }

  // The user types 'pu' in the command window and sees the pen raised so that subsequent movements
  // of the turtle do not leave a trail.

  public void handleCommand(String command) {
    try {
      // Parse command and execute
      Command cmd = parseCommand(command);
      if (cmd instanceof PenUpCommand) {
        PenUpCommand puCmd = (PenUpCommand) cmd;
        puCmd.execute();
      } else {
        cmd.execute();
      }
      model.addCommand(command);

      // Update view
      view.displayCommands(model.getCommands());
      view.displayVariables(model.getVariables());
    } catch (Exception e) {
      view.displayError(e.getMessage());
    }
  }

  // The user types 'clearvariables' in the command window and sees all the defined variables cleared
  // from the environment's history.

  public void handleCommand(String command) {
    try {
      // Parse command and execute
      Command cmd = parseCommand(command);
      if (cmd instanceof ClearVariablesCommand) {
        ClearVariablesCommand clearVarsCmd = (ClearVariablesCommand) cmd;
        clearVarsCmd.execute();
      } else {
        cmd.execute();
      }
      model.addCommand(command);

      // Update view
      view.displayCommands(model.getCommands());
      view.displayVariables(model.getVariables());
    } catch (Exception e) {
      view.displayError(e.getMessage());
    }
  }


}