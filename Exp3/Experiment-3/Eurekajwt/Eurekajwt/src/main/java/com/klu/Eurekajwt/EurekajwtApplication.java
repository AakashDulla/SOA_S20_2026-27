package com.klu.Eurekajwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekajwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekajwtApplication.class, args);
	}

}
