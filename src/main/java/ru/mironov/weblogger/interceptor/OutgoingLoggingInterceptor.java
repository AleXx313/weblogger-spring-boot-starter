package ru.mironov.weblogger.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import ru.mironov.weblogger.util.WebLogUtil;

import java.io.IOException;

/**
 * Пользовательский перехватчик исходящих http запросов
 * Подсчитывает время выполнения запроса и логирует основную информацию о запросе.
 */
public class OutgoingLoggingInterceptor implements ClientHttpRequestInterceptor {

    private final Logger logger = LoggerFactory.getLogger(IncomingLoggingInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        long startTime = System.currentTimeMillis();
        ClientHttpResponse response = execution.execute(request, body);
        logger.info(WebLogUtil.buildOutgoingLog(request, response, System.currentTimeMillis() - startTime));
        return response;
    }
}
