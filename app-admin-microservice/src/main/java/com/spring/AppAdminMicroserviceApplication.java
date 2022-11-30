package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AppAdminMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppAdminMicroserviceApplication.class, args);

	}

}
