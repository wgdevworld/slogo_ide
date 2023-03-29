package slogo.controller;

/**
 * Purpose:
 * <p> Observer that is implemented and added to the back end to receive updates on state changes
 * Assumptions:
 * <p> None
 * Dependencies:
 * <p> None
 * @author Woonggyu Jin
 */


public interface TurtleObserver {

  /**
   * Purpose:
   * <p> Update the observer of a change in the state of the turtle
   * Assumptions:
   * <p> None
   * Parameters:
   * <p> None
   * Exceptions:
   * <p> None
   * Return:
   * <p> None
   * @author Woonggyu Jin
   */

  void updateTurtleState();

}
