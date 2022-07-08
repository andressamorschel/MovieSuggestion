package br.com.suggestion.movie.client;

import br.com.suggestion.movie.dto.movie.GenresList;
import br.com.suggestion.movie.dto.movie.MovieNowPlayingRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "movie", url = "${the.movie.db-api}")
public interface TheMovieDbClient {

    @GetMapping("/movie/now_playing")
    MovieNowPlayingRequest findMoviesInTheaters(@RequestHeader(value = "Authorization")
                                                        String authorizationHeader);

    @GetMapping("/genre/movie/list")
    GenresList getGenres(@RequestHeader(value = "Authorization") String authorizationHeader);
}
