package com.mappy.fizzbuzz.bdd.steps;

import com.mappy.fizzbuzz.model.Request;
import com.mappy.fizzbuzz.model.Result;
import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

/**
 * The type Foo bar qix steps.
 */
public class FizzBuzzSteps extends BaseStep implements En {

    /**
     * Instantiates a new Foo bar qix steps.
     */
    public FizzBuzzSteps() {
        When("user wants to compute the fizzbuzz with the following attributes", (DataTable requestDt) -> {

            testContext().reset();
            List<Request> requestList = requestDt.asList(Request.class);
            // First row of DataTable has the employee attributes hence calling get(0) method.
            super.testContext()
                    .setPayload(requestList.get(0));
            String computeUrl = "/api/compute";
            executePost(computeUrl);
        });
        Then("the server should handle it and the status code is {int}", this::accept);
        Then("the response should with the following result", (DataTable resultTable) -> {
            List<String> resultList = resultTable.asList(String.class);
            List<String> expectedResult = List.of(resultList.get(0).split(","));
            verifyResult(expectedResult);
        });

    }


    private void accept(int expectedResult) {
        Response response = testContext().getResponse();
        Assert.assertEquals(response.getStatusCode(), expectedResult);
    }


    private void verifyResult(List<String> expectedResult) {
        Response response = testContext().getResponse();
        Result result = response.getBody().as(Result.class);
        Assert.assertEquals(result.getResult(), expectedResult);
    }
}
