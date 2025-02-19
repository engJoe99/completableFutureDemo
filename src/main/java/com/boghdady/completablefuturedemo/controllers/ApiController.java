package com.boghdady.completablefuturedemo.controllers;

import com.boghdady.completablefuturedemo.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class ApiController {

    private final ApiService apiService;

    @Autowired
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/getCombinedResult")
    public CompletableFuture<String> getCombinedResult() {
        return apiService.getCombinedResult();
    }
}

