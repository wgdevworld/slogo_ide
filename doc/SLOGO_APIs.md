# SLogo API Design Lab Discussion

### Charles Turpin (cht16), Woonggyu Jin (wj61), Aloye Oshotse (ajo24), Russell Barton (rnb23)

### Team 3

## Planning Questions

* What behaviors (methods) should the Turtle have and what service should it provide?
    * Behaviors:
        * moveForward(distance): This method moves the turtle forward by a specified distance.
        * moveBackward(distance): This method moves the turtle backward by a specified distance.
        * turnLeft(angle): This method rotates the turtle counterclockwise by a specified angle.
        * turnRight(angle): This method rotates the turtle clockwise by a specified angle.
        * penUp(): This method lifts the pen up so that the turtle does not draw a line when it
          moves.
        * penDown(): This method puts the pen down so that the turtle draws a line when it moves.
        * setPenColor(color): This method sets the color of the pen.
        * setPenSize(size): This method sets the size of the pen.
    * Services:
        * Drawing: The turtle provides a service to draw lines on the screen as it moves. The
          penUp() and penDown() methods control when the turtle draws lines.
        * Movement: The turtle provides a service to move on the screen. The moveForward() and
          moveBackward() methods control the distance the turtle moves, while the turnLeft() and
          turnRight() methods control the angle the turtle rotates.
        * Appearance: The turtle provides a service to change its appearance on the screen. The
          setPenColor() and setPenSize() methods control the color and size of the pen used to draw
          lines.

* When does parsing need to take place and what does it need to start properly?
    * Parsing would take place when we load in the commands for the turtles. It would also take
      place when we want to parse the input from the user to see that commands they indicated.

* What is the result of parsing (not the details of the algorithm) and who receives it?

* When are errors detected and how are they reported?
    * Errors should be detected in the front end from user input and when parsing data

* What do different commands need to know, when do they know it, and how do they get it?
    * Most commands only need to know things that will already be global like current XY position,
      current color, current language, or window size

* What behaviors does the result of a command need to have to be used by the View?* How is the View
  updated after a command has completed execution?
    * The result of a command should be a well defined data structure
    * It should be able to convey info about the state of the system
    * The result should be extensible. New functionality should be easily added to the


* What value would Controller(s) have in mediating between the Model and View?
    * The control would receive input from the user in view and pass it to the model
    * The controller can update the view based on changes to the model
    * The controller can manage current state
    * The controller can make sure that the user is staying within the rules of their “contract”

## APIs

### Model/Backend External API

* Parsing user input into commands
* Executing commands and returning output
* Providing feedback to the user (e.g. error messages, success messages)
* Handling user interactions (e.g. button clicks, key presses)
* Updating the display to show the Turtle's movements and any other relevant information

### View/Frontend External API

* Receiving user input and passing it to the back-end logic
* Updating the display to show the Turtle's movements and any other relevant information
* Providing feedback to the user (e.g. error messages, success messages)

### Model/Backend Internal API

* Coordinating the behavior of the Turtle (e.g. moving it, changing its appearance)
* Storing and updating the program's state (e.g. the position and direction of the Turtle, any
  user-defined variables)
* Handling communication between different program components (e.g. between the user interface and
  the back-end logic)
* Providing common utility functions and data structures for use throughout the program

### View/Frontend Internal API

* Managing the user interface components (e.g. buttons, text fields)
* Handling user interactions (e.g. button clicks, key presses)
* Coordinating the interaction between the user interface and the back-end logic
* Updating the display based on the program's state

## Design

### Backend Design CRCs

| Class Name: Command | |
|---------------------------|------------------|
| **Responsibilities:**     | **Collaborators:** |
| - Store information about a parsed SLogo command (get/set methods for command name and parameters) | |
| - Execute the command (execute) | |

| Class Name: CommandFactory | |
|---------------------------|------------------|
| **Responsibilities:**     | **Collaborators:** |
| - Create Command objects based on input string (createCommand) | |
| - Store information about available commands and their parameters | |

| Class Name: Turtle | |
|---------------------------|------------------|
| **Responsibilities:**     | **Collaborators:** |
| - Store current state of the turtle (position, direction, pen state, etc.) (get/set methods) | |
| - Respond to commands that affect its state (move, turn, penUp/penDown, etc.) | |
| - Provide information about its state (getPosition, getDirection, etc.) | |

### Frontend Design CRCs

| Class Name: UserInterface |  |
|---------------------------|-------------------------|
| **Responsibilities:**     | **Collaborators:**       |
| - Receive user input from the keyboard and mouse (getInput) | - CommandParser |
| - Display the output generated by the program (updateDisplay) | - TurtleGraphics |
| - Update the Turtle's position and direction on the screen (updateTurtlePosition) | |
| - Provide feedback to the user (e.g. error messages, success messages) (displayMessage) | |

| Class Name: CommandParser | |
|---------------------------|------------------|
| **Responsibilities:**     | **Collaborators:** |
| - Parse user input into SLogo commands (parseInput) | |
| - Provide error handling (handleErrors) | |

### Use Cases

* The user types 'fd 50' in the command window, sees the turtle move in the display window leaving a
  trail, and has the command added to the environment's history.

* The user types '50 fd' in the command window and sees an error message that the command was not
  formatted correctly.

* The user types 'pu fd 50 pd fd 50' in the command window and sees the turtle move twice (once
  without a trail and once with a trail).

* The user changes the color of the environment's background.

