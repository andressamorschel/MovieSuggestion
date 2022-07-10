package br.com.suggestion.movie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Error finding location")
public class TemperatureNotFoundException extends RuntimeException{

    public TemperatureNotFoundException(String message){
        super(message);
    }

    public TemperatureNotFoundException(){

    }
}
