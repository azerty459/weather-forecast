package fr.nextoo.weatherforecast.controller;

import fr.nextoo.weatherforecast.service.RainyDaysService;
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
public class RainyDaysController {

    @Autowired
    private RainyDaysService rainyDaysService;

    @GetMapping(value = "weather/rainyDays/{ville}")
    public List<String> getRainyDaysByCity(@PathVariable String ville) {
        return rainyDaysService.getRainyDaysByCity(ville);
    }
}
