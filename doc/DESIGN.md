# DESIGN Document for PROJECT_NAME
## Charles Turpin, Aloye Oshotse, Woonggyu Jin, Russell Barton


## Role(s)

* Team member #1
* Charles Turpin, Frontend, GUI

* Team member #2
* Aloye, Backend, commands and parsing

* Team member #3
* Woonggyu, Frontend, Controller, GUI

* Team member #4
* Russell, Backend, commands and parsing


## Design Goals
* Have a GUI that can handle adding new buttons easily
* have a Controller that can connect the view and model.

## High-Level Design
* View class was designed to set up the GUI, including the buttons, canvas for the turtle, command history, and entering 
command inputs. 
* The TurtleGraphics class was designed to set up turtle movement visually. 
* The Controller Class was designed to interact with both the front and back end. Specifically, it sets up a new 
instance of a View, and Turtle. 
* The Turtle class contains the "physical" information about a turtle, based on back end inputs. 
* The Commands class is a super class from which all other commands are created. 
  * This class allowed for us to use reflection to determine the correct subclass for the commands.

## Assumptions or Simplifications
* One assumption we made was only having 1 turtle active, and that made creating multiple turtles more difficult to 
implement. 

## Changes from the Plan
* Overall, we maintained a similar design to the one proposed on the design plan document. 
  * In the front end, the View class is very dense, and we should have split it up into multiple classes. The inclusion 
  a TurtleGraphics/Image classes were not listed initially, but were implemented as a natural progression of our design.

## How to Add New Features
* Adding new features to the GUI would involve making edits to the view class. 
  * For instance, adding multiple views involves creating multiple instances of the View class from the Controller.
  * Interacting with the turtle without typing code means setting up on-click event handlers in the View class. 
  * Adding sliders and prompts is done within the view class, using the makeButton method.