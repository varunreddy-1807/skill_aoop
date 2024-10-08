package loggingsystem;

public abstract class AbstractLogger implements Logger {
    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    @Override
    public void logMessage(LogMessage message) {
        if (canHandle(message.getLevel())) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(message);
        }
    }

    protected abstract boolean canHandle(LogLevel level);
    protected abstract void write(LogMessage message);
}
