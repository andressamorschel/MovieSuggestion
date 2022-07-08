package br.com.suggestion.movie.configuration;

import br.com.suggestion.movie.dto.enumerated.Genres;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenreByTemperatureConfiguration {

    @Bean
    public RangeMap<Double, Genres> buildGenresByTemperature() {
        RangeMap<Double, Genres> config = TreeRangeMap.create();
        config.put(Range.greaterThan(40.0), Genres.ACTION);
        config.put(Range.open(36.0, 40.0), Genres.COMEDY);
        config.put(Range.open(20.0, 35.0), Genres.ANIMATION);
        config.put(Range.open(0.0, 20.00), Genres.THRILLER);
        config.put(Range.lessThan(0.0), Genres.DOCUMENTARY);
        return config;
    }
}
