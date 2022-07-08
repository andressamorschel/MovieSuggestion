package br.com.suggestion.movie.service;

import br.com.suggestion.movie.client.TheMovieDbClient;
import br.com.suggestion.movie.dto.enumerated.CountryCode;
import br.com.suggestion.movie.dto.movie.MovieResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieSuggestionService {

    @Value("${access.token}")
    private String accessToken;
    private final TheMovieDbClient theMovieDbClient;
    private final TemperatureService temperatureService;

    public List<MovieResponse> findMoviesByTemperature(CountryCode country, String city) {
        var locale = city.concat(",").concat(country.getCode());
        var temperature = temperatureService.getTemperature(locale);
        var movies = theMovieDbClient.findMoviesInTheaters(accessToken).getResults();
        var genre = temperatureService.getGenre(temperature);

        return movies.stream()
                .filter(movie -> movie.getGenreIds()
                        .stream()
                        .anyMatch(id -> genre.getId().equals(id)))
                .map(movie -> MovieResponse.builder()
                        .id(movie.getId())
                        .title(movie.getTitle())
                        .adult(movie.isAdult())
                        .originalLanguage(movie.getOriginalLanguage())
                        .overview(movie.getOverview())
                        .releaseDate(movie.getReleaseDate())
                        .build())
                .collect(Collectors.toList());
    }
}
