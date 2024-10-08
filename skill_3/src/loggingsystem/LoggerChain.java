package loggingsystem;

public class LoggerChain {
    private Logger logger;

    public LoggerChain() {

    	InfoLogger infoLogger = new InfoLogger();
        DebugLogger debugLogger = new DebugLogger();
        ErrorLogger errorLogger = new ErrorLogger();

        infoLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(errorLogger);

        this.logger = infoLogger;
    }

    public void log(LogMessage message) {
        logger.logMessage(message);
    }
}
