package fr.nextoo.weatherforecast.controller;

import fr.nextoo.weatherforecast.service.ActualHumidityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "/",
        headers = "Accept=application/json")
public class ActualHumidityController {

    @Autowired
    ActualHumidityService actualHumidityService;

    @GetMapping(value = "weather/actualHumidity/{ville}")
    public Integer getActualHumidity(@PathVariable String ville) {
        return actualHumidityService.getActualHumidity(ville);
    }
}