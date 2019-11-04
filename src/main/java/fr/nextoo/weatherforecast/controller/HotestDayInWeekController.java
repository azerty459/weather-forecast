package fr.nextoo.weatherforecast.controller;

import fr.nextoo.weatherforecast.service.HotestDayInWeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(
        value = "/",
        headers = "Accept=application/json")
public class HotestDayInWeekController {

    @Autowired
    private HotestDayInWeekService hotestDayInWeekService;

    /**
     * Nous retourne le jour le plus chaud de la semaine pour une ville donnée
     * @param ville
     * @return
     */
    @GetMapping(value = "weather/hotestDay/{ville}")
    public String getHotestDayByCity(@PathVariable String ville) {
        return this.hotestDayInWeekService.getHotestDayInWeekByCity(ville);
    }
}
