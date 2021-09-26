package com.mappy.fizzbuzz.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mappy.fizzbuzz.AuditRepository;
import com.mappy.fizzbuzz.model.HitResponse;
import com.mappy.fizzbuzz.model.Request;
import com.mappy.fizzbuzz.model.Result;
import com.mappy.fizzbuzz.service.IFizzBuzzService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * The type Foo bar qix service.
 */
@Service
@Slf4j
public class FizzBuzzService implements IFizzBuzzService {

    private final AuditRepository auditRepository;


    /**
     * Instantiates a new Fizz buzz service.
     *
     * @param auditRepository the audit repository
     */
    public FizzBuzzService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    private Map<Integer, String> fooBarQix;

    public Result process(Request request) {

        fooBarQix = Map.of(request.getFirstNumber(), request.getFirstWord(), request.getSecondNumber(), request.getSecondWord());
        List<String> resultantArray = new ArrayList<>(0);
        for (int i = 1; i <= request.getLimit(); i++) {
            int experimentValue = i;
            StringBuilder result = new StringBuilder();
            result.append(fooBarQix.keySet().stream().sorted().filter(key -> experimentValue % key == 0).map(fooBarQix::get)
                    .collect(Collectors.joining()));
            resultantArray.add(result.toString().isEmpty() ? Integer.toString(experimentValue) : result.toString());
        }
        return Result.builder().result(resultantArray).build();

    }

    @Override
    public HitResponse retrieveStatistics() {

        List<Object[]> retrieveStat = auditRepository.findAllControlRunAfterDate();
        if (ObjectUtils.isNotEmpty(retrieveStat)) {
            Object[] stat = retrieveStat.get(0);
            return HitResponse.builder()
                    .request(getRequest(stat[0].toString()))
                    .numberOfHits(((Number) stat[1]).intValue())
                    .build();
        }
        throw new EntityNotFoundException("API hasn't received the call");
    }

    private Request getRequest(String payload) {
        try {
            return new ObjectMapper()
                    .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                    .enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
                    .readValue(payload, Request.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
