package com.naturalprogrammer.np01.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Np01ConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Np01ConfigServiceApplication.class, args);
	}
}
