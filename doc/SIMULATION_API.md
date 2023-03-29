# Cell Society API Lab Discussion

### Charles Turpin (cht16), Woonggyu Jin (wj61), Aloye Oshotse (ajo24), Russell Barton (rnb23)

### Team 3

## Current Simulation API

### External

* Identified Classes/Methods
    * stop()
    * resume()
    * speedUp()
    * onStep()
    * loadNewFile()
    * save()
    * getGridModel()
    * update()


* Goals
    * Allow the user to control the view of the game
    * Allow the user to manage what game they are running


* Abstractions

* Services and their Contract
    * you could pass in a purposely incorrect gridModel or a Null GridModel
    * resume()
        * allow the user to start from a new file without resetting the timer
    * stop()
        * allows the user to stop or pause the game
    * loadNewFile()
        * user is expected to load a non null correctly formatted file
    * save()
        * user is expected to pass the saved file back in unmodified for predictable outcome

### Internal

* Identified Classes/Methods
    * start()
    * XMLParser
    * CellSocietyView

* Goals
    * Allow the developer to change the game logic and game state, and access data
    * allow the developer to setup expected behavior and intended usage

* Abstractions
    * Handler class
    * GameParams class

* Services and their Contract
    * start()
        * allows the user to reset the timer after changing the file
    * CellSocietyView, making the front end viewable to the user, expect valid input from the model

## Wish Simulation API

### External

* Goals
    * To provide a user-friendly interface for using the cellular automata simulation.

* Abstractions
    * This API could include abstractions such as simulation settings, input parameters, and output
      data structures.

* Services and their Contract
    * The external API should provide services such as initializing and running the simulation,
      accessing the current state of the simulation, and retrieving the results of the simulation.
      The contracts for these services should specify the inputs and outputs required for each
      service and the behavior of the service under different conditions.

### Internal

* Goals
    * To provide a flexible and extensible framework for building the simulation.

* Abstractions
    * This API could include abstractions such as the rules for the cellular automata, the data
      structures used to represent the cells and the grid, and the algorithms used to update the
      state of the grid.

* Services and their Contract
    * The internal API should provide services such as initializing the grid, updating the state of
      the grid based on the rules of the cellular automata, and retrieving information about the
      state of the grid. The contracts for these services should specify the inputs and outputs
      required for each service and the behavior of the service under different conditions.


