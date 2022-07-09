package br.com.suggestion.movie.client;

import br.com.suggestion.movie.dto.temperature.Temperature;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "temperature", url = "${open.weather-api}")
public interface TemperatureFeignClient {

    @GetMapping
    Temperature getTemperature(@RequestParam("q") String city,
                               @RequestParam String appid,
                               @RequestParam String units);
}
