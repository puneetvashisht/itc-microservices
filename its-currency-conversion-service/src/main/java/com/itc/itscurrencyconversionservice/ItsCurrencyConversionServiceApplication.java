package com.itc.itscurrencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.itc.itscurrencyconversionservice")
@EnableDiscoveryClient
public class ItsCurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItsCurrencyConversionServiceApplication.class, args);
	}

}
