package com.mappy.fizzbuzz.config;

import com.mappy.fizzbuzz.service.impl.LoggingService;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;

/**
 * The type Custom request body advice adapter.
 */
@ControllerAdvice
public class CustomRequestBodyAdviceAdapter extends RequestBodyAdviceAdapter {

    private final HttpServletRequest httpServletRequest;
    private final LoggingService loggingService;

    /**
     * Instantiates a new Custom request body advice adapter.
     *
     * @param httpServletRequest the http servlet request
     * @param loggingService     the logging service
     */
    public CustomRequestBodyAdviceAdapter(HttpServletRequest httpServletRequest, LoggingService loggingService) {
        this.httpServletRequest = httpServletRequest;
        this.loggingService = loggingService;
    }


    @Override
    public boolean supports(MethodParameter methodParameter, Type type,
                            Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage,
                                MethodParameter parameter, Type targetType,
                                Class<? extends HttpMessageConverter<?>> converterType) {

        loggingService.logRequest(httpServletRequest, body);

        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
    }
}
