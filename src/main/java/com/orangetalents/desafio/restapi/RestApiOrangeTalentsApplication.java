package com.orangetalents.desafio.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RestApiOrangeTalentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiOrangeTalentsApplication.class, args);
	}

}
