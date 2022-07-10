package br.com.suggestion.movie.service;

import br.com.suggestion.movie.client.TheMovieDbClient;
import br.com.suggestion.movie.dto.enumerated.CountryCode;
import br.com.suggestion.movie.dto.movie.MovieNowPlayingRequest;
import br.com.suggestion.movie.dto.movie.Results;
import br.com.suggestion.movie.exception.ErrorSearchingMoviesException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @InjectMocks
    private MovieService movieService;

    @Value("${access.token}")
    private String accessToken;

    @Mock
    private TheMovieDbClient theMovieDbClient;

    @Mock
    private TemperatureService temperatureService;

    private MovieNowPlayingRequest movieNowPlayingRequest;

    @BeforeEach
    void setup() {
        List<Integer> genreIds = new ArrayList<>();
        Results results = new Results(false, genreIds, 1L, "en",
                "The Mummy", "very good :)", LocalDate.now(), "The Mummy");

        this.movieNowPlayingRequest = new MovieNowPlayingRequest(null, 2, List.of(results),
                10, 1);
    }

    @Test
    void shouldReturnListOfMovies() {
        when(theMovieDbClient.findMoviesInTheaters(accessToken)).thenReturn(movieNowPlayingRequest);

        var response = movieService.findMoviesByTemperature(CountryCode.BRAZIL,
                "Campo Bom");

        assertNotNull(response);
    }

    @Test
    void shouldReturnErrorSearchingMoviesExceptionWhenToCallFindMoviesInTheaters(){
        when(theMovieDbClient.findMoviesInTheaters(accessToken))
                .thenThrow(new ErrorSearchingMoviesException("Error fetching movies from provider"));

        assertThrows(ErrorSearchingMoviesException.class, () -> movieService
                .findMoviesByTemperature(CountryCode.BRAZIL, "Porto Alegre"));
    }
}
