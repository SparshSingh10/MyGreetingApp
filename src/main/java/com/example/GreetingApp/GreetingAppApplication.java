package com.example.GreetingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.GreetingApp")
public class GreetingAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(GreetingAppApplication.class, args);
	}
}
