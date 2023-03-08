package com.codolis.medalite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Medalite API", description = "Medalite REST API Documentation."))
public class MedaliteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedaliteApplication.class, args);
	}

	// You can access API docs at http://localhost:8080/v3/api-docs  
	
	// View API docs with Swagger API at http://localhost:8080/docs/swagger-ui.html, in explore type:  /v3/api-docs
}
