/*
 It states that high-level modules should not depend on low-level modules. Both should depend on abstractions.
 Dpeendency Inversion Principle (DIP) for abstarction
  High level modules should always be in a abstarct state then only it won't tightly coupled.
*/

//violation code

class FileLogger{
    public void  log(String message) {
        System.out.println("Logging to file: " + message);
    }
}
class App{
    FileLogger fileLogger = new FileLogger();

    public void process(){
        fileLogger.log("log the data");
    }
}

//non violation code

interface Logger{
    void log(String message);
}

class FileLoggerImpl implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Logging to file: " + message);
    }
}

class consoleLogger implements Logger{
    @Override
    public void log(String message) {
        System.out.println("Logging to console: " + message);
    }
}

class AppNonViolated{
    Logger logger;
    AppNonViolated(Logger logger){
        this.logger = logger;
    }

    public void logMessage(){
        logger.log("Log some info");
    }
}
public class DependencyInversionPrinciple {
}
