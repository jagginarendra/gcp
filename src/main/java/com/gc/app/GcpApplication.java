package com.gc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SpringBootApplication
public class GcpApplication {

	public static void main(String[] args) {
		SpringApplication.run(GcpApplication.class, args);
		Object object = new Object();
		Lock lock = new ReentrantLock();


	}

}

@RestController
class MyController{

	@GetMapping("/test")
	public String getMessage(){
		return "Hello World V3";
	}

}



