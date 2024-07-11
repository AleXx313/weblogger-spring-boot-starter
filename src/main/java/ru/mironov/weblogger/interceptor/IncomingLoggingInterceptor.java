package ru.mironov.weblogger.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import ru.mironov.weblogger.util.WebLogUtil;

/**
 * Пользовательский перехватчик входящих http запросов
 * Подсчитывает время выполнения запроса и логирует основную информацию о запросе.
 */
public class IncomingLoggingInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(IncomingLoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        long startTime = System.currentTimeMillis();
        request.setAttribute(WebLogUtil.TIME_ATTRIBUTE, startTime);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) {
        long time = System.currentTimeMillis() - ((long) request.getAttribute(WebLogUtil.TIME_ATTRIBUTE));
        logger.info(WebLogUtil.buildIncomingLog(request, response, time));
    }
}
