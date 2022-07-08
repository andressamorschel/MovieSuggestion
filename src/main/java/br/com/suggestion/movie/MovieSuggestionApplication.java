package br.com.suggestion.movie;

import br.com.suggestion.movie.service.MovieSuggestionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MovieSuggestionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieSuggestionApplication.class, args);
	}

}
