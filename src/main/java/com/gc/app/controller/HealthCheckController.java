package com.gc.app.controller;

import com.gc.app.service.HealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @Autowired
    HealthCheckService healthCheckService;

    @GetMapping("/ping")
    public ResponseEntity<String> checkHealth() {
        return healthCheckService.checkServerStatus();
    }
}


