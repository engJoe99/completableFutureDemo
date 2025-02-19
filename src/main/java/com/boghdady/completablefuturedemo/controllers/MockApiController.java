package com.boghdady.completablefuturedemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockApiController {

    @GetMapping("/api1")
    public String api1() {
        return "Response from API 1";
    }

    @GetMapping("/api2")
    public String api2() {
        return "Response from API 2";
    }

    @GetMapping("/api3")
    public String api3() {
        return "Response from API 3";
    }
}