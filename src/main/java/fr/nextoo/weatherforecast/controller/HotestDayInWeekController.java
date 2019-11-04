package fr.nextoo.weatherforecast.controller;

import fr.nextoo.weatherforecast.service.HotestDayInWeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "/",
        headers = "Accept=application/json")
public class HotestDayInWeekController {

    @Autowired
    private HotestDayInWeekService hotestDayInWeekService;

    @GetMapping(value = "weather/hotestDay/{ville}")
    public String getHotestDayByCity(@PathVariable String ville) {
        return hotestDayInWeekService.getHotestDayInWeekByCity(ville);
    }
}
