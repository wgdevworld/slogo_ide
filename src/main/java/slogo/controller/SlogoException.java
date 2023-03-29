package slogo.controller;

public class SlogoException extends RuntimeException{

  public SlogoException(String message) {
    super(message);
  }

  public SlogoException(Throwable cause, String message) {
    super(message, cause);
  }
}