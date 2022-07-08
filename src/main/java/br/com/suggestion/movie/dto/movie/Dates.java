package br.com.suggestion.movie.dto.movie;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Dates {

    private LocalDate maximum;

    private LocalDate minimum;
}
