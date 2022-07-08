package br.com.suggestion.movie.dto.temperature;

import lombok.Data;

@Data
public class TemperatureRequest {

    private Coord coord;

    private Weather[] weather;

    private String base;

    private Main main;

    private Long visibility;

    private Wind wind;

    private Cloud clouds;

    private Long dt;

    private Sys sys;

    private Long timezone;

    private Long id;

    private String name;

    private Integer cod;
}
