package com.example.electronics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.example.electronics.infrastructure",
        "com.example.electronics.infradetails.persistence"
})
@EnableJpaRepositories(basePackages = {
        "com.example.electronics.infradetails.persistence.repository"
})

@EntityScan(basePackages = {
        "com.example.electronics.infradetails.persistence.entity"
})

public class ElectronicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectronicsApplication.class, args);
	}

}
