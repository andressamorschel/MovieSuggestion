package br.com.suggestion.movie.dto.movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MovieNowPlayingRequest {

    private Dates dates;

    private Integer pages;

    private List<Results> results;

    @JsonProperty("total_pages")
    private Integer totalPages;

    @JsonProperty("total_results")
    private Integer totalResults;
}
