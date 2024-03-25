package com.APIEquipos;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiEquiposApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiEquiposApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(){
		return new OpenAPI()
				.info(new Info()
						.title("API Prueba Tecnica")
						.version("0.0.1 SNAPSHOT")
						.description("API hecha con Spring Boot 3 y Java 17 encargada de realizar peticiones a una base de datos H2 de equipos, ligas y paises.")
						.contact(new Contact().name("Mateo Ferradans").email("mferradanss@gmail.com").url("https://www.linkedin.com/in/mateo-ferradans/"))
				);
	}

}
