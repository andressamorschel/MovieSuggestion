package br.com.suggestion.movie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "Error fetching movies from provider")
public class ErrorSearchingMoviesException extends RuntimeException {

    public ErrorSearchingMoviesException(String message) {
        super(message);
    }
}
