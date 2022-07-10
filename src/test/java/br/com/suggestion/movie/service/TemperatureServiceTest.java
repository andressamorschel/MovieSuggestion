package br.com.suggestion.movie.service;

import br.com.suggestion.movie.client.TemperatureFeignClient;
import br.com.suggestion.movie.dto.enumerated.Genres;
import br.com.suggestion.movie.dto.temperature.Main;
import br.com.suggestion.movie.dto.temperature.Temperature;
import br.com.suggestion.movie.exception.TemperatureNotFoundException;
import com.google.common.collect.RangeMap;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class TemperatureServiceTest {

    @InjectMocks
    private TemperatureService temperatureService;

    @Mock
    private TemperatureFeignClient temperatureFeignClient;

    @Mock
    private RangeMap<Double, Genres> genreByTemperature;

    @Value("${appid}")
    private String appid;

    private static final String UNITS = "metric";

    String locale = "Alvorada,076";

    private Temperature temperature;

    @BeforeEach
    void setup() {
        Main main = new Main(20.0, 15.3, 23.0);
        this.temperature = new Temperature(main);
    }

    @Test
    void shouldReturnTheCorrectTemperatureValue() {
        when(temperatureFeignClient.getTemperature(any(), any(), any())).thenReturn(temperature);

        var response = temperatureService.getTemperature(locale);

        assertEquals(response, 20.0);
    }

    @Test
    void shouldReturnTemperatureNotFoundExceptionWhenToCallGetTemperature() {
        when(temperatureFeignClient.getTemperature(any(), any(), any()))
                .thenThrow(new TemperatureNotFoundException());

        assertThrows(TemperatureNotFoundException.class, () -> temperatureService
                .getTemperature(locale));
    }

    @Test
    void shouldReturnActionWhenGetGenreMethodIsCalled() {
        when(genreByTemperature.get(any())).thenReturn(Genres.ACTION);

        var response = temperatureService.getGenre(40.0);

        assertEquals(response.getId(), 28);
    }

    @Test
    void shouldReturnComedyWhenGetGenreMethodIsCalled() {
        when(genreByTemperature.get(any())).thenReturn(Genres.COMEDY);

        var response = temperatureService.getGenre(36.0);

        assertEquals(response.getId(), 35);
    }

    @Test
    void shouldReturnAnimationWhenGetGenreMethodIsCalled() {
        when(genreByTemperature.get(any())).thenReturn(Genres.ANIMATION);

        var response = temperatureService.getGenre(35.0);

        assertEquals(response.getId(), 16);
    }

    @Test
    void shouldReturnThrillerWhenGetGenreMethodIsCalled() {
        when(genreByTemperature.get(any())).thenReturn(Genres.THRILLER);

        var response = temperatureService.getGenre(0.0);

        assertEquals(response.getId(), 53);
    }

    @Test
    void shouldReturnDocumentaryWhenGetGenreMethodIsCalled() {
        when(genreByTemperature.get(any())).thenReturn(Genres.DOCUMENTARY);

        var response = temperatureService.getGenre(Double.MIN_VALUE);

        assertEquals(response.getId(), 99);
    }
}
