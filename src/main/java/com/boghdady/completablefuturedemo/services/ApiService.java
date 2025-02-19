package com.boghdady.completablefuturedemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

// Service class to handle asynchronous API calls
@Service
public class ApiService {

    // RestTemplate instance for making HTTP requests
    private final RestTemplate restTemplate;

    // Constructor injection of RestTemplate
    @Autowired
    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Asynchronously calls API 1 endpoint
    public CompletableFuture<String> callApi1() {
        return CompletableFuture.supplyAsync(() -> restTemplate.getForObject("http://localhost:8080/api1", String.class));
    }

    // Asynchronously calls API 2 endpoint
    public CompletableFuture<String> callApi2() {
        return CompletableFuture.supplyAsync(() -> restTemplate.getForObject("http://localhost:8080/api2", String.class));
    }

    // Asynchronously calls API 3 endpoint
    public CompletableFuture<String> callApi3() {
        return CompletableFuture.supplyAsync(() -> restTemplate.getForObject("http://localhost:8080/api3", String.class));
    }

    // Combines results from all three API calls asynchronously
    public CompletableFuture<String> getCombinedResult() {
        // Make all three API calls in parallel
        CompletableFuture<String> api1 = callApi1();
        CompletableFuture<String> api2 = callApi2();
        CompletableFuture<String> api3 = callApi3();

        // Combine results with | separator
        // First combine api1 and api2 results, then combine that with api3 result
        return api1.thenCombine(api2, (result1, result2) -> result1 + " | " + result2)
                .thenCombine(api3, (combinedResult, result3) -> combinedResult + " | " + result3);
    }
}