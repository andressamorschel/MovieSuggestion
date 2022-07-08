package br.com.suggestion.movie.dto.temperature;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Main {

    private Double temp;

    @JsonProperty("feels_like")
    private Float feelsLike;

    @JsonProperty("temp_min")
    private Float tempMin;

    @JsonProperty("temp_max")
    private Float tempMax;

    private Long pressure;

    private Long humidity;

    @JsonProperty("sea_level")
    private Integer seaLevel;

    @JsonProperty("grnd_level")
    private Integer grndLevel;
}

