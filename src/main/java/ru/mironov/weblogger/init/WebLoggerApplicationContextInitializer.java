package ru.mironov.weblogger.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import ru.mironov.weblogger.bean.ThreadsInfo;

public class WebLoggerApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final Logger LOG = LoggerFactory.getLogger(WebLoggerApplicationContextInitializer.class);

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        LOG.info("Вызов WebLoggerApplicationContextInitializer");
        applicationContext.getBeanFactory().registerSingleton(ThreadsInfo.class.getSimpleName(), new ThreadsInfo());
    }
}
