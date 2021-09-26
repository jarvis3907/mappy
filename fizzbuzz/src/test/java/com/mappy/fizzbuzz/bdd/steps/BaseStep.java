package com.mappy.fizzbuzz.bdd.steps;

import com.mappy.fizzbuzz.bdd.CucumberTestContext;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.Map;


/**
 * The type Base step.
 */
public abstract class BaseStep {


    private CucumberTestContext CONTEXT = CucumberTestContext.CONTEXT;

    @LocalServerPort
    private int port;

    /**
     * Base url string.
     *
     * @return the string
     */
    protected String baseUrl() {
        return "http://localhost:" + port;
    }

    /**
     * Test context cucumber test context.
     *
     * @return the cucumber test context
     */
    protected CucumberTestContext testContext() {
        return CONTEXT;
    }


    /**
     * Execute get.
     *
     * @param apiPath the api path
     */
    protected void executeGet(String apiPath) {
        executeGet(apiPath, null, null);
    }

    /**
     * Execute get.
     *
     * @param apiPath     the api path
     * @param pathParams  the path params
     * @param queryParams the query params
     */
    protected void executeGet(String apiPath, Map<String, String> pathParams, Map<String, String> queryParams) {
        final RequestSpecification request = CONTEXT.getRequest();
        final String url = baseUrl() + apiPath;

        setQueryParams(pathParams, request);
        setPathParams(queryParams, request);

        Response response = request.accept(ContentType.JSON)
                .log()
                .all()
                .get(url);

        logResponse(response);
        CONTEXT.setResponse(response);
    }

    private void logResponse(Response response) {
        response.then()
                .log()
                .all();
    }

    private void setPathParams(Map<String, String> queryParamas, RequestSpecification request) {
        if (null != queryParamas) {
            request.queryParams(queryParamas);
        }
    }

    private void setQueryParams(Map<String, String> pathParams, RequestSpecification request) {
        if (null != pathParams) {
            request.pathParams(pathParams);
        }
    }

    /**
     * Execute post.
     *
     * @param apiPath the api path
     */
    protected void executePost(String apiPath) {
        executePost(apiPath, null, null);
    }

    /**
     * Execute post.
     *
     * @param apiPath    the api path
     * @param pathParams the path params
     */
    protected void executePost(String apiPath, Map<String, String> pathParams) {
        executePost(apiPath, pathParams, null);
    }

    /**
     * Execute post.
     *
     * @param apiPath      the api path
     * @param pathParams   the path params
     * @param queryParamas the query paramas
     */
    protected void executePost(String apiPath, Map<String, String> pathParams, Map<String, String> queryParamas) {
        final RequestSpecification request = CONTEXT.getRequest();
        final Object payload = CONTEXT.getPayload();
        final String url = baseUrl() + apiPath;

        setPayload(request, payload);
        setQueryParams(pathParams, request);
        setPathParams(queryParamas, request);

        Response response = request.accept(ContentType.JSON)
                .log()
                .all()
                .post(url);

        logResponse(response);

        CONTEXT.setResponse(response);
    }

    private void setPayload(RequestSpecification request, Object payload) {
        if (null != payload) {
            request.contentType(ContentType.JSON)
                    .body(payload);
        }
    }

}
