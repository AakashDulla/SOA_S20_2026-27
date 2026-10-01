package com.klu.studentapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StudentapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentapplicationApplication.class, args);
	}

}
