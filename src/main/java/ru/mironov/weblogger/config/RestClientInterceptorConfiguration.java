package ru.mironov.weblogger.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import ru.mironov.weblogger.interceptor.OutgoingLoggingInterceptor;

import java.util.ArrayList;
import java.util.List;

@AutoConfiguration
@AutoConfigureAfter(WebLoggerAutoConfiguration.class)
@ConditionalOnBean(name = "incomingLoggingInterceptor")
public class RestClientInterceptorConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        if (CollectionUtils.isEmpty(interceptors)) {
            interceptors = new ArrayList<>();
        }
        interceptors.add(new OutgoingLoggingInterceptor());
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }

    @Bean
    public RestClient restClient() {
        return RestClient.create(restTemplate());
    }
}
