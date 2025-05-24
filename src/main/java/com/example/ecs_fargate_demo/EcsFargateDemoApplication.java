package com.example.ecs_fargate_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.AbstractEnvironment;

@SpringBootApplication
public class EcsFargateDemoApplication {

	public static void main(String[] args) {
		// Force prod profile and disable local profile
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "prod");
		System.setProperty(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME, "prod");
		SpringApplication app = new SpringApplication(EcsFargateDemoApplication.class);
		app.setAdditionalProfiles("prod");
		app.run(args);
	}

}
