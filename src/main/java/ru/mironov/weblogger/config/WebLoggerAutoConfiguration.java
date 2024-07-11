package ru.mironov.weblogger.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import ru.mironov.weblogger.config.property.WebLoggerProperties;
import ru.mironov.weblogger.interceptor.IncomingLoggingInterceptor;
import ru.mironov.weblogger.interceptor.OutgoingLoggingInterceptor;

@AutoConfiguration
@EnableConfigurationProperties(WebLoggerProperties.class)
@ConditionalOnProperty(prefix = "web.logger", value = "enabled", havingValue = "true", matchIfMissing = false)
public class WebLoggerAutoConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "web.logger", value = "incoming-enabled", havingValue = "true", matchIfMissing = true)
    public IncomingLoggingInterceptor incomingLoggingInterceptor(){
        return new IncomingLoggingInterceptor();
    }

    @Bean
    @ConditionalOnProperty(prefix = "web.logger", value = "outgoing-enabled", havingValue = "true", matchIfMissing = true)
    public OutgoingLoggingInterceptor outgoingLoggingInterceptor(){
        return new OutgoingLoggingInterceptor();
    }
}
