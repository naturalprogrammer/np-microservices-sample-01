package com.naturalprogrammer.np01.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Np01DiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Np01DiscoveryServiceApplication.class, args);
	}
}
