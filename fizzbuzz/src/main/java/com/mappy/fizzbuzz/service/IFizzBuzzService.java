package com.mappy.fizzbuzz.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.mappy.fizzbuzz.model.HitResponse;
import com.mappy.fizzbuzz.model.Request;
import com.mappy.fizzbuzz.model.Result;

/**
 * The interface Foo bar qix service.
 */
public interface IFizzBuzzService {


    /**
     * Process result.
     *
     * @param value the value
     * @return the result
     */
    Result process(Request value);

    /**
     * Retrieve statistics hit response.
     *
     * @return the hit response
     * @throws JsonProcessingException the json processing exception
     */
    HitResponse retrieveStatistics() throws JsonProcessingException;
}
