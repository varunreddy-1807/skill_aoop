package loggingsystem;

public class InfoLogger extends AbstractLogger {

    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.INFO;
    }

    @Override
    protected void write(LogMessage message) {
        System.out.println("INFO: " + message.getMessage());
    }
}

