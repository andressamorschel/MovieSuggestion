package br.com.suggestion.movie.dto.temperature;

import lombok.Data;

@Data
public class Weather {

    private Long id;

    private String main;

    private String description;

    private String icon;
}
