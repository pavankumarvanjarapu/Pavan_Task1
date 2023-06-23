package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//@RestController
public class SkillServiceApplication {
//private Environment environment;
//	
//	
//
//	public SkillServiceApplication(Environment environment) {
//		super();
//		this.environment = environment;
//	}

	public static void main(String[] args) {
		SpringApplication.run(SkillServiceApplication.class, args);
	}
//	@GetMapping
//	public ResponseEntity<?> getStatus()
//	{
//		return ResponseEntity.ok("skill-tracker-service is up and running on port: "+environment.getProperty("local.server.port"));
//	}

}