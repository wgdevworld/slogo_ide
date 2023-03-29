public interface Model {
  void addCommand(String command);
  void clear();
  List<String> getCommands();
  Map<String, Double> getVariables();
  void setVariable(String variable, double value);
}