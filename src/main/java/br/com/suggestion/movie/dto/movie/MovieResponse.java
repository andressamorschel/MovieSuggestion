package br.com.suggestion.movie.dto.movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponse {

    private Long id;

    private String title;

    private String originalTitle;

    private String overview;

    private String genre;
}
