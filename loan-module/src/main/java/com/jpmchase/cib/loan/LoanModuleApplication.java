package com.jpmchase.cib.loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LoanModuleApplication {
	public static void main(String[] args) {
		SpringApplication.run(LoanModuleApplication.class, args);
	}
}
