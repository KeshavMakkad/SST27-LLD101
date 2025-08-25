public class ConsoleLogger implements ILogger {
    public void log(String msg) {
        System.out.println("[LOG] " + msg);
    }
}