package com.mappy.fizzbuzz.service;

import com.mappy.fizzbuzz.AuditRepository;
import com.mappy.fizzbuzz.model.HitResponse;
import com.mappy.fizzbuzz.model.Request;
import com.mappy.fizzbuzz.model.Result;
import com.mappy.fizzbuzz.service.impl.FizzBuzzService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mappy.fizzbuzz.utils.TestUtils.asJsonString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


/**
 * The type Foo bar qix service test.
 */
@ExtendWith(AuditRepoParameterResolver.class)
@RunWith(JUnitPlatform.class)
public class FizzBuzzServiceTest {


    /**
     * The Foo bar qix service.
     */
    FizzBuzzService fizzBuzzService;

    /**
     * Sets up.
     *
     * @param auditRepository the audit repository
     */
    @BeforeEach
    public void setUp(@Mock AuditRepository auditRepository) {

        auditRepository = Mockito.mock(AuditRepository.class);
        fizzBuzzService = new FizzBuzzService(auditRepository);
        List<Object[]> result = new ArrayList<>();
        Object[] mockedResponse = {asJsonString(Request.builder()
                .firstNumber(3)
                .firstWord("fizz")
                .secondNumber(5)
                .secondWord("buzz")
                .limit(5)
                .build()),
                4};
        result.add(mockedResponse);
        when(auditRepository.findAllControlRunAfterDate()).thenReturn(result);

    }

    /**
     * Test computation.
     */
    @Test
    void testComputation() {

        Result case1 = fizzBuzzService.process(Request.builder()
                .firstNumber(3)
                .firstWord("fizz")
                .secondNumber(5)
                .secondWord("buzz")
                .limit(5)
                .build());
        assertEquals(Arrays.asList("1", "2", "fizz", "4", "buzz"), case1.getResult(), "Asserting the result for value for limit: 5");

    }

    /**
     * Fetch statistics.
     */
    @Test
    void fetchStatistics() {
        HitResponse response = fizzBuzzService.retrieveStatistics();
        assertNotNull(response);
        assertEquals(4, response.getNumberOfHits(), "Asserting the number of hits");
    }

}
