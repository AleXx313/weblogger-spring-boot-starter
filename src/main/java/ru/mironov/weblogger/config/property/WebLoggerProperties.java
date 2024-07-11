package ru.mironov.weblogger.config.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix = "web.logger")
public class WebLoggerProperties {

    private Boolean enabled;
    private Boolean incomingEnabled;
    private Boolean outgoingEnabled;

}
