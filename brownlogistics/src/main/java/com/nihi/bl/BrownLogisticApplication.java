package com.nihi.bl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigurationProperties
@RestController
public class BrownLogisticApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(BrownLogisticApplication.class, args);
	}
	@GetMapping(value = "/")
	public String project() {
	      System.out.println("project started");
	   return "project Started";
	}
}
