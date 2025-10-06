package com.aplication.pharmacysystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.aplication.pharmacysystem")
public class PharmacySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmacySystemApplication.class, args);
	}

}
