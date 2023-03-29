public interface Command {
    void execute();
    void parse(String command);
}