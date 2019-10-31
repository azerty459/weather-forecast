package fr.nextoo.weatherforecast.controller;

import fr.nextoo.weatherforecast.dto.WeatherDto;
import fr.nextoo.weatherforecast.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(
        value = "/",
        headers = "Accept=application/json")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    /**
     * Nous retourne la méteo pour ville donnée pour les 5 jours a venir
     * @param ville
     * @return
     */
    @GetMapping(value = "weather/{ville}")
    public List<WeatherDto> getWeatherByCity(@PathVariable String ville) {
        return weatherService.getWeatherByCity(ville);
    }
}
