package com.mappy.fizzbuzz.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * The type Hit response.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HitResponse {

    private int numberOfHits;
    private Request request;
}
