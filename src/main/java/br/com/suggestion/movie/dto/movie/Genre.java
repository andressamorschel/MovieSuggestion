package br.com.suggestion.movie.dto.movie;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Genre {

    private int id;

    private String name;
}
