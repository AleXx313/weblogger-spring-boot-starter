package ru.mironov.weblogger.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "web.logger")
public class WebLoggerProperties {

    private Boolean enabled;
    private Boolean incomingEnabled;
    private Boolean outgoingEnabled;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getIncomingEnabled() {
        return incomingEnabled;
    }

    public void setIncomingEnabled(Boolean incomingEnabled) {
        this.incomingEnabled = incomingEnabled;
    }

    public Boolean getOutgoingEnabled() {
        return outgoingEnabled;
    }

    public void setOutgoingEnabled(Boolean outgoingEnabled) {
        this.outgoingEnabled = outgoingEnabled;
    }
}
