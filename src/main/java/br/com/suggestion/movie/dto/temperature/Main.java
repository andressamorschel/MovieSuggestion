package br.com.suggestion.movie.dto.temperature;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Main {

    private Double temp;

    @JsonProperty("temp_min")
    private Double tempMin;

    @JsonProperty("temp_max")
    private Double tempMax;
}

