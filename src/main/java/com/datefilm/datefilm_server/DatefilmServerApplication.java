package com.datefilm.datefilm_server;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@OpenAPIDefinition(servers = {@Server(url="/api",description = "스프링부트 context path")})
@EnableJpaAuditing
@SpringBootApplication
public class DatefilmServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatefilmServerApplication.class, args);
	}

}
