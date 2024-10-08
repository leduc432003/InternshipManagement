package com.duc.taskuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TaskuserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskuserserviceApplication.class, args);
	}

}
