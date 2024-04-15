package com.jpmchase.cib.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayModuleApplication.class, args);
	}

}
