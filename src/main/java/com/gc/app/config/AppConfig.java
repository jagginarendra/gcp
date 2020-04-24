package com.gc.app.config;

import com.gc.app.controller.ApplicationWarmupController;
import com.gc.app.service.HealthCheckService;
import com.gc.app.service.HealthCheckServiceImpl;
import com.gc.app.service.WarmUpService;
import com.gc.app.service.WarmUpServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public HealthCheckService healthCheckService(){
        return new HealthCheckServiceImpl();
    }


    @Bean
    public WarmUpService warmUpService(){
        return new WarmUpServiceImpl();
    }

    @Bean
    public ApplicationWarmupController warmupController(){
        return new ApplicationWarmupController();
    }

}
