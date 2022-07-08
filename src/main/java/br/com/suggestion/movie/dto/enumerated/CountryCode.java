package br.com.suggestion.movie.dto.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CountryCode {
    BRAZIL("076"), CHINA("156"), CANADA("124"), MADAGASCAR("450"), GREENLAND("304");

    @Getter
    private final String code;
}
