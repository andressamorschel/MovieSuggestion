package br.com.suggestion.movie.dto.movie;

import lombok.Data;

@Data
public class RangeOfGenres {

    private Integer initTemperature;

    private Integer lastTemperature;

    private Genre genre;
}
