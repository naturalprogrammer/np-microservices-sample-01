package com.naturalprogrammer.np01.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.naturalprogrammer.np01.lib001.scan.Lib001Configuration;

@SpringBootApplication(scanBasePackageClasses= {
		Np01ProfileServiceApplication.class,
		Lib001Configuration.class
})
@EnableFeignClients
public class Np01ProfileServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Np01ProfileServiceApplication.class, args);
	}
}
