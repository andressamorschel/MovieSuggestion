package br.com.suggestion.movie.dto.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Genres {
    ACTION(28), COMEDY(35), ANIMATION(16), THRILLER(53), DOCUMENTARY(99);

    @Getter
    private final Integer id;
}
