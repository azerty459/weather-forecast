package nxt.weather.controller;

import java.util.List;
import nxt.weather.controller.dto.ForecastDto;
import nxt.weather.controller.dto.HumidityDto;
import nxt.weather.controller.dto.ReturnDto;
import nxt.weather.service.WeatherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller de l'API Rest sur l'url .../meteo/ville/{nom de la ville}[/...]
 * @author Arthur Brandao
 */
@RestController
@RequestMapping("/meteo/")
@CrossOrigin
public class WeatherController {
    
    /**
     * Le service utilisé pour traiter les informations et retourner les données demandées
     * Le Autowired permet de ne pas faire de new Spring s'occuper de récupérer l'instance (de base en singleton)
     */
    @Autowired
    private WeatherInfoService weatherInfoService;
    
    /*
    Note : 
    Les objest retourné sont transformé en JSON par Jackson
    */

    /**
     * Retourne les infos météo du jour courrant et des jours à venir
     * @param city Nom de la ville
     * @return Liste de prévision
     */
    @GetMapping("/ville/{city}")
    public ReturnDto<List<ForecastDto>> weather(@PathVariable String city) {
        city = city.replaceAll("[ |']", "-");
        return weatherInfoService.weather(city);
    }

    /**
     * Retourne les infos du jour le plus chaud (parmis les 4 prochains)
     * @param city Nom de la ville
     * @return Prévision du jour
     */
    @GetMapping("/ville/{city}/chaleur")
    public ReturnDto<ForecastDto> heat(@PathVariable String city) {
        city = city.replaceAll("[ |']", "-");
        return weatherInfoService.heat(city);
    }

    /**
     * Retourne les prévisions des jours où il pleut
     * @param city Nom de la ville
     * @return Liste de prévision
     */
    @GetMapping("/ville/{city}/pluie")
    public ReturnDto<List<ForecastDto>> rain(@PathVariable String city) {
        city = city.replaceAll("[ |']", "-");
        return weatherInfoService.rain(city);
    }

    /**
     * Retourne le taux d'humidité actuel et moyen de la semaine
     * @param city Nom de la ville
     * @return 
     */
    @GetMapping("/ville/{city}/humidite")
    public ReturnDto<HumidityDto> humidity(@PathVariable String city) {
        city = city.replaceAll("[ |']", "-");
        return weatherInfoService.humidity(city);
    }

}
