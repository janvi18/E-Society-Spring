package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class EnhomesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnhomesApplication.class, args);
	}

	@Bean
	public OpenAPI myapi() {
		OpenAPI api = new OpenAPI();
		Info info = new Info();
		info.title("enhomes").version("1.0").description("Rest API Doc For Enhomes").termsOfService("www.enhomes.com");
		api.info(info);
		return api;

	}

}
