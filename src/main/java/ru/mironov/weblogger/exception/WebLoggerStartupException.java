package ru.mironov.weblogger.exception;

public class WebLoggerStartupException extends RuntimeException{

    public WebLoggerStartupException() {
    }

    public WebLoggerStartupException(String message) {
        super(message);
    }
}
