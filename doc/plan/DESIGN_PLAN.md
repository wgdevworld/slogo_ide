# SLogo Design Plan
### Charles Turpin, Russell Barton, Woonggyu Jin, Aloye Oshotse
### TEAM 03


## Introduction
* Create basic SLogo language to use for an IDE made from scratch

* GUI shows turtle performing commands based on user input along with other features (shown in GUI wireframe)

* Design Goals: To have a clean GUI with fully functioning buttons, to have a controller that manages instructions passed between GUI and model, to have a simplified version of SLOGO capable of supporting user-defined commands.

* Open/Closed: Closed: The logic behind implementing commands, specifically, what happens when a user creates a new variable/command. The controller between front/back end. Open: adding new UI elements (color, style, languages, etc).

* High-level description(no mention of classes): When the user starts the program from, they get a splash page asking what language to run the program in. Then, the view populates the GUI. When a user enters input into the GUI, the controller handles it and tells the model what to do and the view updates accordingly.

## Configuration File Format

The example configurations are in the data folder. They are titled example1.xml and example2.xml.

## Design Overview

### Abstract classes:

Turtle abstraction - methods for moving the Turtle and changing attributes such as pencolor and size.

Command abstraction - each subclass could represent a different command. These classes could have a 
method for parsing out the command data from user input, executing the command, and returning any
relevant output (this could also be replaced by commands in an XML file).

Expression abstraction - these subclasses can be split up for variables, conditionals, loops,
mathematical expressions, etc. It would provide methods for evaluating expressions and returning a
value if necessary (could break this abstraction down into separate abstractions).

Parser abstraction - this class could provide methods for parsing the SLogo code (user input) into
commands and expressions objects (mentioned earlier) to create objects for each part of the code.

Interpreter abstraction - this abstraction would run the program. This would serve as the "main program
method" for the program. It would use all the previously stated abstractions to get information from
either a configuration file or user input, parse the code using the Parser abstraction into Commands
and Expression abstractions, and execute the code which would manipulate the Turtle objects.


### Extra useful class:

Canvas class - Area for drawing on the screen; methods for clearing the screen, and drawing the 
lines for the turtle path

Previous Command History class - Uses a stack to track previous valid command

SLogoView - puts all the UI components together to create the frontend

ErrorDisplay - displays any errors in a user-friendly way

UserInput - takes in the input of the user and converts into a format that the program can use


## Design Details

All the specific details of each abstraction is listed above. The method signatures in our design
will not reveal differences in different implementation by using an abstract class or an interface
that defines the methods and in the subclass or implementation, we can be more specific about how we
want to handle these methods.


## Design Considerations
We choose the classes we did because we believe that it would lead to the easiest implementation of
the SLogo program. 

One consideration we had in mind was to use XML files to load in commands for the
program and even converting user input into a parsable XML file. One pro of this would be that we would
not need to make a lot of classes for each command. Instead, we would only have a Parser class that
looks at an XML file and execute the code. A con for this design would be that one of the classes
that would be interpreting these files would be convoluted and would struggle to follow the Single
Responsibility Principle.

Another consideration we had in mind was using a Controller for this project. The pro of this would
be that it would make the code more readable and each class would follow the Single Responsibility
Principle. I cannot see many cons to this method, so we may go with it.

## Test Plan

 * We will use meaningful names for our methods and classes to make it easier to understand the purpose of each method and how it should be tested
 * We will write smaller methods that follow the single responsibility principle to make it easier to isolate and test specific functionality 
 * We have identified four main features of our program for which we will write test scenarios. For each feature, we have identified three test scenarios, one of which is negative/sad/error producing. We have also described the expected outcome and how our design supports testing for each scenario. The four main features and their test scenarios are described below:
   * Interpreter 
     * Happy: Test that the interpreter is able to interpret a valid command and execute it correctly. The expected outcome is that the turtle should move to the expected location, and the interpreter should return the correct output. Our design supports testing for this scenario by providing a method to execute a command and methods to check the turtle's location and the interpreter's output
     * (Sad) Invalid Command: Test that the interpreter throws an exception when an invalid command is entered. The expected outcome is that an exception should be thrown with a clear error message. Our design supports testing for this scenario by providing a method to execute a command and a method to check if an exception was thrown
     * (Sad) Unsupported Feature: Test that the interpreter throws an exception when an unsupported feature is used. The expected outcome is that an exception should be thrown with a clear error message. Our design supports testing for this scenario by providing a method to execute a command and a method to check if an exception was thrown
   * Resource Manager
     * Happy: Test that the resource manager is able to correctly store and retrieve a variable. The expected outcome is that the correct value of the variable should be returned. Our design supports testing for this scenario by providing methods to store and retrieve variables
     * (Sad) Nonexistent Variable: Test that the resource manager throws an exception when a nonexistent variable is retrieved. The expected outcome is that an exception should be thrown with a clear error message. Our design supports testing for this scenario by providing a method to retrieve a resource and a method to check if an exception was thrown
     * (Sad) Invalid Resource Name: Test that the resource manager throws an exception when an invalid resource name is used. The expected outcome is that an exception should be thrown with an explicit error message. Our design supports testing for this scenario by providing a method to store a variable and a method to check if an exception was thrown
   * Command Monitor
     * Happy: Test that the command history is able to correctly store and retrieve a command. The expected outcome is that the correct command should be returned. Our design supports testing for this scenario by providing methods to store and retrieve commands
     * (Sad) Nonexistent Command: Test that the command monitor throws an exception when a nonexistent command is retrieved. The expected outcome is that an exception should be thrown with a clear error message. Our design supports testing for this scenario by providing a method to retrieve a command and a method to check if an exception was thrown
     * (Sad) Maximum Command Limit: Test that the command monitor throws an exception when the maximum command limit is reached. The expected outcome is that an exception should be thrown with a clear error message. Our design supports testing for this scenario by providing a method to store a command and a method to check if an exception was thrown
   * Turtle 
     * Happy: Test that the turtle is able to draw a valid shape correctly. The expected outcome is that the shape should be drawn correctly on the screen. Our design supports testing for this scenario by providing methods to set the pen color, pen size, and to move the turtle in different directions
     * (Sad) Invalid Pen Color: Test that the turtle throws an exception when an invalid pen color is used. The expected outcome is that an exception should be thrown with a clear error message. Our design supports testing for this scenario by providing a method to set the pen color and a method to check if an exception was thrown
     * (Sad) Negative Pen Size: Test that the turtle throws an exception when a negative pen size is used. The expected outcome is that an exception should be thrown with a clear error message. Our design supports testing for this scenario by providing a method to set the pen size and a method to check if an exception was thrown

## Team Responsibilities

 * Team Member #1: Woonggyu Jin
   * Working on the Controller. This would include working on the Interpreter class. This is class
      would put all the abstract classes together to make the program run. 

 * Team Member #2: Charles Turpin
   * Working on the View of the project. This includes working on the UI (for user input and command
      history), the canvas, and the visualization of the Turtle object. 

 * Team Member #3: Russell Barton
   * Working on the Model of the project. Will work primarily with the Command and Turtle abstractions
      while also secondarily helping Aloye with the Parser and Expression abstractions.

 * Team Member #4: Aloye Oshotse
   * Working on the Model of the Project. So, this includes working on the abstractions listed earlier.
   I will primarily be working on the Parser and Expression Abstractions while secondarily helping 
   Russell with the Turtle and Command Abstractions.

## Timeline
* Basic design by 2/24, refactor 2/25, submit Test 2/26, add features 2/27 through 3/03, refactor 3/04 and Submit Basic (clean design structure, as many core features as possible while prioritizing design cleanliness over volume of features)  3/05

