package fr.nextoo.weatherforecast.service.impl;

import fr.nextoo.weatherforecast.dto.WeatherDto;
import fr.nextoo.weatherforecast.service.RainyDaysService;
import fr.nextoo.weatherforecast.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RainyDaysServiceImpl implements RainyDaysService {

    @Autowired
    public WeatherService weatherService;

    @Override
    public List<String> getOnlyRainyDaysByCity(String ville) {
        List<WeatherDto> responseApi = weatherService.getWeatherByCity(ville);
        List<WeatherDto> rainDays = responseApi.stream()
                .filter(l -> l.getIlPleut())
                .collect(Collectors.toList());
        List<String> result = rainDays.stream()
                .map(WeatherDto::getDate)
                .collect(Collectors.toList());
        //Dedoublonage de la la liste resultat, car elle contient plusieurs fois la meme date a cause de l'intervale des heures
        List<String> date = result.stream()
                .distinct()
                .collect(Collectors.toList());
        return date;
    }
}
