package ru.mironov.weblogger.init;

import org.apache.commons.logging.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.logging.DeferredLogFactory;
import org.springframework.core.env.ConfigurableEnvironment;
import ru.mironov.weblogger.exception.WebLoggerStartupException;

public class WebLoggerEnvironmentPostProcessor implements EnvironmentPostProcessor {

    private final Log log;

    public WebLoggerEnvironmentPostProcessor(DeferredLogFactory logFactory) {
        this.log = logFactory.getLog(WebLoggerEnvironmentPostProcessor.class);
    }

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        log.info("Вызов WebLoggerEnvironmentPostProcessor");

        String enablePropertyValue = environment.getProperty("web.logger.enabled");
        if (enablePropertyValue != null) {
            boolean isBoolValue = Boolean.TRUE.toString().equals(enablePropertyValue) ||
                    Boolean.FALSE.toString().equals(enablePropertyValue);
            if (!isBoolValue){
                throw new WebLoggerStartupException("Ошибка при проверке свойства 'web.logger.enabled'!");
            }
        }
    }
}
