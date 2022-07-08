package br.com.suggestion.movie.service;

import br.com.suggestion.movie.client.TemperatureFeignClient;
import br.com.suggestion.movie.dto.enumerated.Genres;
import br.com.suggestion.movie.exception.TemperatureNotFoundException;
import com.google.common.collect.RangeMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

@Service
@Slf4j
@RequiredArgsConstructor
public class TemperatureService {

    @Value("${appid}")
    private String appid;
    private static final String UNITS = "metric";
    private final TemperatureFeignClient temperatureFeignClient;
    private final RangeMap<Double, Genres> genreByTemperature;

    public Double getTemperature(String locale) {
        try {
            var temperature = temperatureFeignClient.getTemperature(locale, appid, UNITS);
            log.info("temperature {}", temperature);
            return temperature.getMain().getTemp();
        } catch (HttpStatusCodeException e) {
            if (e.getStatusCode().is4xxClientError()) {
                throw new TemperatureNotFoundException("country or city not found");
            }

            throw new RuntimeException("error to call temperature api");
        }

    }

    public Genres getGenre(Double temperature) {
        return genreByTemperature.get(temperature);
    }
}
