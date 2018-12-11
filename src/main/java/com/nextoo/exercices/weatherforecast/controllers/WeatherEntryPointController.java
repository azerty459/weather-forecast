package com.nextoo.exercices.weatherforecast.controllers;

import com.nextoo.exercices.weatherforecast.services.TownWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author nextoo
 */
@RestController
public class WeatherEntryPointController {

    @Autowired
    private TownWeatherService townWeatherService;


    /**
     * donne la météo des prochains jours pour une ville
     * @param ville
     * @return
     */
    @RequestMapping("/weather/{ville}")
    public String getWeather(@PathVariable final String ville) {
        if (!StringUtils.isEmpty(ville)) {
            return townWeatherService.getWeatherForTown(ville);
        }
        return null;
    }


    /**
     * donne le jours le plus chaud de la semaine
     * @param ville
     * @return
     */
    @RequestMapping("/weather/hottestdayinWeek/{ville}")
    public String getHottestDayInWeek(@PathVariable final String ville) {
        if (!StringUtils.isEmpty(ville)) {
            return townWeatherService.getHottestDayInWeek(ville);
        }
        return null;
    }

    /**
     * donne uniquement les jours où il pleut
     * @param ville
     * @return
     */
    @RequestMapping("/weather/rainy/{ville}")
    public String getRainyDaysForTown(@PathVariable final String ville) {
        if (!StringUtils.isEmpty(ville)) {
            return townWeatherService.getRainyDays(ville);
        }
        return null;
    }

    /**
     *  donne les villes où il fait le plus chaud dans un périmètre
     * @param perimetre
     * @return
     */
    @RequestMapping("/weather/hotterthanin/{ville}/{perimetre}")
    public String getHotterThanIn(@PathVariable final String ville, @PathVariable final Integer perimetre) {
        if (perimetre != null && perimetre > 0) {

        }
        return null;
    }


    /**
     * donne l'humidité actuelle et celle moyenne de la semaine
     * @param ville
     * @return
     */
    @RequestMapping("/weather/humidity/{ville}")
    public String getHumidityAverage(@PathVariable final String ville) {
        if (!StringUtils.isEmpty(ville)) {
            return " aujourd'hui : humidite = " + townWeatherService.getTodayHumidityValue(ville)
                    + " / humidite moyenne de la semaine = " + townWeatherService.getWeekHumidityAverage(ville).getAsDouble();
        }
        return null;
    }
}
