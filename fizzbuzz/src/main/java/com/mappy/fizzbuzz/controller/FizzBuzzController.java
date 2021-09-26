package com.mappy.fizzbuzz.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mappy.fizzbuzz.model.HitResponse;
import com.mappy.fizzbuzz.model.Request;
import com.mappy.fizzbuzz.model.Result;
import com.mappy.fizzbuzz.service.IFizzBuzzService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * The type Foo bar qix controller.
 */
@RestController
@RequestMapping(value = "compute")
public class FizzBuzzController {

    private IFizzBuzzService iFizzBuzzService;

    /**
     * Instantiates a new Foo bar qix controller.
     *
     * @param iFizzBuzzService the foo bar qix service
     */
    public FizzBuzzController(IFizzBuzzService iFizzBuzzService) {
        this.iFizzBuzzService = iFizzBuzzService;
    }

    /**
     * Compute post response entity.
     *
     * @param value the value
     * @return the response entity
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> computePost(@Valid @RequestBody Request value) {
        return new ResponseEntity<>(iFizzBuzzService.process(value),
                HttpStatus.OK);
    }


    /**
     * Compute post stat response entity.
     *
     * @return the response entity
     * @throws JsonProcessingException the json processing exception
     */
    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HitResponse> computePostStat() throws JsonProcessingException {
        return new ResponseEntity<>(iFizzBuzzService.retrieveStatistics(),
                HttpStatus.OK);
    }
}
