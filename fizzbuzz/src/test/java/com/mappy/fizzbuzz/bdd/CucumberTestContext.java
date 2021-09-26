package com.mappy.fizzbuzz.bdd;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static java.lang.ThreadLocal.withInitial;

/**
 * Singleton to manage objects and share their state between step definitions.
 */
public enum CucumberTestContext {
    /**
     * Context cucumber test context.
     */
    CONTEXT;

    private static final String PAYLOAD = "PAYLOAD";
    private static final String REQUEST = "REQUEST";
    private static final String RESPONSE = "RESPONSE";

    private final ThreadLocal<Map<String, Object>> threadLocal = withInitial(HashMap::new);

    private Map<String, Object> testContextMap() {
        return threadLocal.get();
    }

    /**
     * Set.
     *
     * @param key   the key
     * @param value the value
     */
    public void set(String key, Object value) {
        testContextMap().put(key, value);
    }

    /**
     * Get object.
     *
     * @param key the key
     * @return the object
     */
    public Object get(String key) {
        return testContextMap().get(key);
    }

    /**
     * Get t.
     *
     * @param <T>   the type parameter
     * @param key   the key
     * @param clazz the clazz
     * @return the t
     */
    public <T> T get(String key, Class<T> clazz) {
        return clazz.cast(testContextMap().get(key));
    }

    /**
     * Sets payload.
     *
     * @param value the value
     */
    public void setPayload(Object value) {
        set(PAYLOAD, value);
    }

    /**
     * Gets payload.
     *
     * @return the payload
     */
    public Object getPayload() {
        return testContextMap().get(PAYLOAD);
    }

    /**
     * Gets payload.
     *
     * @param <T>   the type parameter
     * @param clazz the clazz
     * @return the payload
     */
    public <T> T getPayload(Class<T> clazz) {
        return get(PAYLOAD, clazz);
    }

    /**
     * Gets request.
     *
     * @return the request
     */
    public RequestSpecification getRequest() {
        RequestSpecification req = get(REQUEST, RequestSpecification.class);
        return (null == req) ? given() : req;
    }

    /**
     * Sets response.
     *
     * @param response the response
     */
    public void setResponse(Response response) {
        set(RESPONSE, response);
    }

    /**
     * Gets response.
     *
     * @return the response
     */
    public Response getResponse() {
        return get(RESPONSE, Response.class);
    }

    /**
     * Reset.
     */
    public void reset() {
        testContextMap().clear();
    }

}
