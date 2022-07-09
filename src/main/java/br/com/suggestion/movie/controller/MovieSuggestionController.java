package br.com.suggestion.movie.controller;

import br.com.suggestion.movie.dto.enumerated.CountryCode;
import br.com.suggestion.movie.dto.movie.MovieResponse;
import br.com.suggestion.movie.exception.TemperatureNotFoundException;
import br.com.suggestion.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieSuggestionController {

    private final MovieService movieSuggestionService;

    @GetMapping("/{country}/{city}")
    public List<MovieResponse> findMoviesByTemperature(@PathVariable CountryCode country,
                                                       @PathVariable String city) {
        try {
            return movieSuggestionService.findMoviesByTemperature(country, city);
        } catch (Exception e) {
            throw new TemperatureNotFoundException("Country or city not found");
        }
    }
}
