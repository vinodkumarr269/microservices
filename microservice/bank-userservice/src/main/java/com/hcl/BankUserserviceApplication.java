package com.hcl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BankUserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankUserserviceApplication.class, args);
	}

}
