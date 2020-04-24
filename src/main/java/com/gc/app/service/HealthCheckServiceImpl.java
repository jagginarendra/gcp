package com.gc.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HealthCheckServiceImpl implements HealthCheckService {

    @Autowired
    WarmUpService warmUpService;

    @Override
    public ResponseEntity<String> checkServerStatus() {
        if(warmUpService.isWarmUpCompleted()){
            return ResponseEntity.ok("pong");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
