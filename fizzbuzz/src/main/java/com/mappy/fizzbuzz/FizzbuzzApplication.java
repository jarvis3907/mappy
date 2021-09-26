package com.mappy.fizzbuzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * The type Fizzbuzz application.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class FizzbuzzApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
		SpringApplication.run(FizzbuzzApplication.class, args);
	}

}
