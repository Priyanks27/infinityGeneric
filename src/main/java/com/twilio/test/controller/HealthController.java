package com.twilio.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/")
    public String health()
    {
        return "success";
    }

    @GetMapping("/health")
    public String health1()
    {
        return "success form generic controller!";
    }
}
