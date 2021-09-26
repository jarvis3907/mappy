package com.mappy.fizzbuzz.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

/**
 * The type Request.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Request {

    @NotNull(message = "firstWord is compulsory")
    @NotBlank(message = "firstWord is compulsory")
    @Pattern(regexp = "[a-z-A-Z]*", message = "firstWord has invalid characters")
    private String firstWord;

    @NotNull(message = "secondWord is compulsory")
    @NotBlank(message = "secondWord is compulsory")
    @Pattern(regexp = "[a-z-A-Z]*", message = "secondWord has invalid characters")
    private String secondWord;

    @NotNull
    @Positive(message = " firstNumber cannot be null and it should be greater than 0")
    private int firstNumber;

    @NotNull
    @Positive(message = " firstNumber cannot be null and it should be greater than 0")
    private int secondNumber;

    @NotNull
    @Positive(message = " limit cannot be null and it should be greater than 0")
    private int limit;
}
