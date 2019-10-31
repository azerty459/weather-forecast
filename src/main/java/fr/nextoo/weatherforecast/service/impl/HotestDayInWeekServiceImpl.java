package fr.nextoo.weatherforecast.service.impl;

import fr.nextoo.weatherforecast.dto.WeatherDto;
import fr.nextoo.weatherforecast.service.HotestDayInWeekService;
import fr.nextoo.weatherforecast.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class HotestDayInWeekServiceImpl implements HotestDayInWeekService {

    @Autowired
    public WeatherService weatherService;

    @Override
    public String getHotestDayByCity(String ville) {
        List<WeatherDto> responseApi = weatherService.getWeatherByCity(ville);
        Double maxTemp = responseApi.stream()
                .mapToDouble(l -> l.getTemperature_max())
                .max()
                .getAsDouble();
        String hotestDay = responseApi.stream()
                .sorted(Comparator.comparing(WeatherDto::getTemperature_max).reversed())
                .findFirst()
                .map(WeatherDto::getDate)
                .get();
        return hotestDay;
    }
}
