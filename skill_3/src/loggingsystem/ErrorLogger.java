package loggingsystem;

public class ErrorLogger extends AbstractLogger {

    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.ERROR;
    }

    @Override
    protected void write(LogMessage message) {
        System.out.println("ERROR: " + message.getMessage());
    }
}
