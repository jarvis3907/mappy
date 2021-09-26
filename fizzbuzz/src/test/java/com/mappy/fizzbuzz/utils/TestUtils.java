package com.mappy.fizzbuzz.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The type Test utils.
 */
public class TestUtils {

    /**
     * As json string string.
     *
     * @param obj the obj
     * @return the string
     */
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
