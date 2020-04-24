package com.gc.app.service;

import org.springframework.http.ResponseEntity;

public interface HealthCheckService {

    ResponseEntity<String> checkServerStatus();

}
