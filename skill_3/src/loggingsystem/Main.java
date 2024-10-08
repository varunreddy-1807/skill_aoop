package loggingsystem;

public class Main {
    public static void main(String[] args) {
        LoggerChain loggerChain = new LoggerChain();

        loggerChain.log(new LogMessage("This is an info message.", LogLevel.INFO));
        loggerChain.log(new LogMessage("This is a debug message.", LogLevel.DEBUG));
        loggerChain.log(new LogMessage("This is an error message.", LogLevel.ERROR));
    }
}

