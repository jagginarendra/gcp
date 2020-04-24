package com.gc.app;

import com.gc.app.controller.ApplicationWarmupController;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SpringBootApplication
public class GcpApplication implements ApplicationContextAware {

	private static ApplicationContext gcpAppContext;

	public static void main(String[] args) {
		SpringApplication.run(GcpApplication.class, args);
		if(gcpAppContext != null){
			ApplicationWarmupController warmupController = gcpAppContext.getBean(ApplicationWarmupController.class);
			warmupController.preStart();
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		gcpAppContext = applicationContext;
	}
}

@RestController
class MyController{

	@GetMapping("/test")
	public String getMessage(){
		return "Hello World with health check";
	}

}



