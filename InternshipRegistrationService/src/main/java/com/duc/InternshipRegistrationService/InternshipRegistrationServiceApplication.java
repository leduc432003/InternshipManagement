package com.duc.InternshipRegistrationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class InternshipRegistrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternshipRegistrationServiceApplication.class, args);
	}

}
