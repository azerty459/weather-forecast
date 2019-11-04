package fr.nextoo.weatherforecast.controller;

import fr.nextoo.weatherforecast.api.dto.ForecastApiDto;
import fr.nextoo.weatherforecast.api.service.ForecastServiceApi;
import fr.nextoo.weatherforecast.dto.ForecastDto;
import fr.nextoo.weatherforecast.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "/",
        headers = "Accept=application/json")
public class ForecastController {

    @Autowired
    private ForecastService forecastService;

    @GetMapping(value = "weather/{ville}")
    public ForecastDto getWeatherByCity(@PathVariable String ville) {
        return forecastService.getForecastByCity(ville);
    }

}
