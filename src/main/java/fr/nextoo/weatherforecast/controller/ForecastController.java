package fr.nextoo.weatherforecast.controller;

import fr.nextoo.weatherforecast.dto.ForecastDto;
import fr.nextoo.weatherforecast.dto.MainDto;
import fr.nextoo.weatherforecast.dto.PrevisionDto;
import fr.nextoo.weatherforecast.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/",
        headers = "Accept=application/json")
public class ForecastController {

    @Autowired
    private ForecastService forecastService;

    @CrossOrigin
    @GetMapping(value = "weather/{ville}")
    public ForecastDto getWeatherByCity(@PathVariable String ville) {
        return forecastService.getForecastByCity(ville);
    }

    @CrossOrigin
    @GetMapping(value = "weather/actualHumidity/{ville}")
    public MainDto getActualHumidity(@PathVariable String ville) {
        return forecastService.getActualHumidity(ville);
    }

    @CrossOrigin
    @GetMapping(value = "weather/hottestDay/{ville}")
    public PrevisionDto getHotestDayByCity(@PathVariable String ville) {
        return forecastService.getHotestDayInWeekByCity(ville);
    }

    @CrossOrigin
    @GetMapping(value = "weather/rainyDays/{ville}")
    public List<String> getRainyDaysByCity(@PathVariable String ville) {
        return forecastService.getRainyDaysByCity(ville);
    }

}
