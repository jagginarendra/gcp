package com.gc.app.service;

public class WarmUpServiceImpl implements WarmUpService {

    volatile boolean warmup = false;

    @Override
    public void startWarmUp() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        warmup = true;

    }

    @Override
    public boolean isWarmUpCompleted() {
        return warmup;
    }
}
