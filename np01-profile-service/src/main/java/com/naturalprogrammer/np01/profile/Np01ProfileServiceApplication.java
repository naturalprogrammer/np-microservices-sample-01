package com.naturalprogrammer.np01.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.naturalprogrammer.np01.lib001.scan.Lib001Configuration;

@SpringBootApplication(scanBasePackageClasses= {
		Np01ProfileServiceApplication.class,
		Lib001Configuration.class
})
@EnableTransactionManagement
public class Np01ProfileServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Np01ProfileServiceApplication.class, args);
	}
}
