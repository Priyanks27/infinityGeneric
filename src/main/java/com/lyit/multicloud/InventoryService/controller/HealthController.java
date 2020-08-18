package com.lyit.multicloud.InventoryService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/")
    public String health()
    {
        return "success v10";
    }
}