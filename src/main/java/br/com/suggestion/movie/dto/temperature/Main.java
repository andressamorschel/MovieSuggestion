package br.com.suggestion.movie.dto.temperature;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Main {

    private Double temp;

    @JsonProperty("temp_min")
    private Float tempMin;

    @JsonProperty("temp_max")
    private Float tempMax;
}

