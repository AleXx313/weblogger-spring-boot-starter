package ru.mironov.weblogger.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.mironov.weblogger.interceptor.IncomingLoggingInterceptor;

@AutoConfiguration
@AutoConfigureAfter(WebLoggerAutoConfiguration.class)
@ConditionalOnBean(name = "outgoingLoggingInterceptor")
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new IncomingLoggingInterceptor());
    }

}
