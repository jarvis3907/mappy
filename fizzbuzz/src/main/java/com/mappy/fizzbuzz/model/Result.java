package com.mappy.fizzbuzz.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * The type Result.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result {

    private List<String> result;
}
