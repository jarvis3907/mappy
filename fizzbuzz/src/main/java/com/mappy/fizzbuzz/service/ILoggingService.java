package com.mappy.fizzbuzz.service;

import javax.servlet.http.HttpServletRequest;

/**
 * The interface Logging service.
 */
public interface ILoggingService {

    /**
     * Log request.
     *
     * @param httpServletRequest the http servlet request
     * @param body               the body
     */
    void logRequest(HttpServletRequest httpServletRequest, Object body);
}
