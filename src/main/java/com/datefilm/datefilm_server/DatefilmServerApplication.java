package com.datefilm.datefilm_server;

import io.github.cdimascio.dotenv.Dotenv;
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

        // .env 파일 로드
        Dotenv dotenv = Dotenv.configure().load();
        // 환경 변수를 시스템 속성으로 설정
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));


        SpringApplication.run(DatefilmServerApplication.class, args);
    }

}