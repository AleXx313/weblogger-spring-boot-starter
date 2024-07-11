package ru.mironov.weblogger.config;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import ru.mironov.weblogger.interceptor.IncomingLoggingInterceptor;
import ru.mironov.weblogger.interceptor.OutgoingLoggingInterceptor;

import static org.assertj.core.api.Assertions.assertThat;

class WebLoggerAutoConfigurationTest {

    private final ApplicationContextRunner runner =
            new ApplicationContextRunner().withConfiguration(AutoConfigurations.of(WebLoggerAutoConfiguration.class));

    @Test
    public void init_whenWebLoggerEnabled_thenAllStarterBeansInitialized() {
        runner.withPropertyValues(
                        "web.logger.enabled=true")
                .withUserConfiguration(WebLoggerAutoConfiguration.class)
                .run(applicationContext -> {
                    assertThat(applicationContext).hasSingleBean(IncomingLoggingInterceptor.class);
                    assertThat(applicationContext).hasSingleBean(OutgoingLoggingInterceptor.class);
                });
    }

    @Test
    public void init_whenWebLoggerEnabled_thenAllStarterBeansInitialized1() {
        runner.withPropertyValues(
                        "web.logger.enabled=true", "web.logger.outgoing-enabled: false")
                .withUserConfiguration(WebLoggerAutoConfiguration.class)
                .run(applicationContext -> {
                    assertThat(applicationContext).hasSingleBean(IncomingLoggingInterceptor.class);
                    assertThat(applicationContext).doesNotHaveBean(OutgoingLoggingInterceptor.class);
                });
    }

    @Test
    public void init_whenWebLoggerEnabled_thenAllStarterBeansInitialized2() {
        runner.withPropertyValues(
                        "web.logger.enabled=true", "web.logger.incoming-enabled: false")
                .withUserConfiguration(WebLoggerAutoConfiguration.class)
                .run(applicationContext -> {
                    assertThat(applicationContext).hasSingleBean(OutgoingLoggingInterceptor.class);
                    assertThat(applicationContext).doesNotHaveBean(IncomingLoggingInterceptor.class);
                });
    }

    @Test
    public void init_whenWebLoggerEnabled_thenAllStarterBeansInitialized3() {
        runner.withPropertyValues()
                .withUserConfiguration(WebLoggerAutoConfiguration.class)
                .run(applicationContext -> {
                    assertThat(applicationContext).doesNotHaveBean(OutgoingLoggingInterceptor.class);
                    assertThat(applicationContext).doesNotHaveBean(IncomingLoggingInterceptor.class);
                });
    }
}