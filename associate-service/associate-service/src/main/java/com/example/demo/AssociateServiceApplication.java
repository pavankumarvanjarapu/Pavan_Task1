package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
//@RestController
public class AssociateServiceApplication {
//private Environment environment;
//	
//	
//
//	public AssociateServiceApplication(Environment environment) {
//		super();
//		this.environment = environment;
//	}

	public static void main(String[] args) {
		SpringApplication.run(AssociateServiceApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
//	@GetMapping
//	public ResponseEntity<?> getStatus()
//	{
//		return ResponseEntity.ok("skill-tracker-service is up and running on port: "+environment.getProperty("local.server.port"));
//	}

}