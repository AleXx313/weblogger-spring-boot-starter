package ru.mironov.weblogger.analyzer;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;
import ru.mironov.weblogger.exception.WebLoggerStartupException;

public class WebLoggerFailureAnalyzer extends AbstractFailureAnalyzer<WebLoggerStartupException> {

    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, WebLoggerStartupException cause) {
        return new FailureAnalysis(cause.getMessage(), "Укажите валидные значения для свойств", cause);
    }
}
