package br.com.suggestion.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MovieSuggestionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieSuggestionApplication.class, args);
	}

	/*  todo -> documentação
		todo -> Open API, Swagger
		todo -> Testes unitários
		todo -> refactor dtos
		todo -> sonarQube
	 */
}