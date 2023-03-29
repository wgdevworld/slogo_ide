public interface View {
  void displayCommands(List<String> commands);
  void displayVariables(Map<String, Double> variables);
  void displayError(String errorMessage);
}