public interface Controller {
  void handleCommand(String command);
  void handleVariableAssignment(String variable, double value);
  void handleClear();
}