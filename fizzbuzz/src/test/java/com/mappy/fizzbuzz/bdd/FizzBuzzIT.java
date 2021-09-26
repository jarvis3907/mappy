package com.mappy.fizzbuzz.bdd;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * The type Foo bar qix it.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:feature", plugin = {"pretty",
        "json:target/cucumber-report.json"})
public class FizzBuzzIT {

}
