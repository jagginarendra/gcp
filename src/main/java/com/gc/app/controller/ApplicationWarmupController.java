package com.gc.app.controller;

import com.gc.app.service.WarmUpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ApplicationWarmupController {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationWarmupController.class);


    @Autowired
    WarmUpService warmUpService;

    public void preStart(){
        try{
            logger.info("Starting warmup");
            warmUpService.startWarmUp();
            logger.info("Ended warmup");
        }catch (Exception e){
            logger.error("Exception during warmup");
        }
    }
}
