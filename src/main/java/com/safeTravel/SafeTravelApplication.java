package com.safeTravel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.safeTravel.controller"
})
public class SafeTravelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafeTravelApplication.class, args);
	}

}
