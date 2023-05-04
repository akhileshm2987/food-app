package com.global.foodorderingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.global.foodorderingapp.controller", "com.global.foodorderingapp.service.impl"})
@EnableJpaRepositories("com.global.foodorderingapp.repository")
@EntityScan("com.global.foodorderingapp.entity")
public class FoodOrderingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodOrderingAppApplication.class, args);
	}

}
