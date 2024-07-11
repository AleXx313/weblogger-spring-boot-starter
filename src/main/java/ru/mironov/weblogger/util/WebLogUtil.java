package ru.mironov.weblogger.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

public class WebLogUtil {

    public static final String TIME_ATTRIBUTE = "timeAttribute";

    public static String buildIncomingLog(HttpServletRequest request, HttpServletResponse response, long time) {
        StringBuilder sb = new StringBuilder();
        buildIncomingRequestLog(request, sb);
        buildIncomingResponseLog(response, sb);
        sb.append("\nRequest Time         : ").append(time).append("ms");
        sb.append("\n=============Incoming Request Logging End==============");
        return sb.toString();
    }

    public static void buildIncomingRequestLog(HttpServletRequest request, StringBuilder sb) {
        sb.append("\n=============Incoming Request Logging Start============");
        sb.append("\nRequest Url          : ").append(request.getRequestURL());
        sb.append("\nRequest Method       : ").append(request.getMethod());
        sb.append("\nRequest IP           : ").append(request.getRemoteAddr());
        sb.append("\nRequest Headers      : ").append(getHeader(request));
    }

    public static void buildIncomingResponseLog(HttpServletResponse response, StringBuilder sb) {
        sb.append("\nResponse Status      : ").append(response.getStatus());
        sb.append("\nResponse Headers     : ").append(getHeader(response));
    }

    public static String buildOutgoingLog(HttpRequest request, ClientHttpResponse response, long time) {
        StringBuilder sb = new StringBuilder();
        buildOutgoingRequestLog(request, sb);
        buildOutgoingResponseLog(response, sb);
        sb.append("\nRequest Time         : ").append(time).append("ms");
        sb.append("\n=============Outgoing Request Logging End==============");
        return sb.toString();
    }

    public static void buildOutgoingRequestLog(HttpRequest request, StringBuilder sb) {
        sb.append("\n=============Outgoing Request Logging Start============");
        sb.append("\nRequest Url          : ").append(request.getURI());
        sb.append("\nRequest Method       : ").append(request.getMethod());
        sb.append("\nRequest Headers      : ").append(getHeader(request));
    }

    public static String buildOutgoingResponseLog(ClientHttpResponse response, StringBuilder sb) {
        String responseCode = "";
        try {
            responseCode = response.getStatusCode().toString();
        } catch (IOException ignored) {
        }
        sb.append("\nRequest Url          : ").append(responseCode);
        sb.append("\nRequest Headers      : ").append(getHeader(response));
        return sb.toString();
    }

    public static String getHeader(HttpMessage request) {
        StringBuilder sb = new StringBuilder();
        HttpHeaders headers = request.getHeaders();
        for (Map.Entry<String, List<String>> header : headers.entrySet()) {
            sb.append(header.getKey());
            sb.append(": ");
            sb.append(header.getValue());
            sb.append("\n                       ");
        }
        return sb.toString();
    }

    private static String getHeader(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            sb.append(headerName);
            sb.append(": ");
            sb.append(request.getHeader(headerName));
            sb.append("\n                       ");
        }
        return sb.toString();
    }

    private static String getHeader(HttpServletResponse response) {
        StringBuilder sb = new StringBuilder();
        Collection<String> headerNames = response.getHeaderNames();
        for (String headerName : headerNames) {
            sb.append(headerName);
            sb.append(": ");
            sb.append(response.getHeader(headerName));
            sb.append("\n                       ");
        }
        return sb.toString();
    }
}
