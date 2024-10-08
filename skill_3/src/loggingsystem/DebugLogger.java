package loggingsystem;

public class DebugLogger extends AbstractLogger {

    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.DEBUG;
    }

    @Override
    protected void write(LogMessage message) {
        System.out.println("DEBUG: " + message.getMessage());
    }
}
