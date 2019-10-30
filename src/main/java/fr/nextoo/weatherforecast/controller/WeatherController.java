package fr.nextoo.weatherforecast.controller;

import fr.nextoo.weatherforecast.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "/",
        headers = "Accept=application/json")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping(value = "weather/{ville}")
    public Object getWeatherByCity(@PathVariable String ville) {
        return this.weatherService.getWeatherByCity(ville);
    }

}
