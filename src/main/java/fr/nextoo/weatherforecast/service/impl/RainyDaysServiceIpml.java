package fr.nextoo.weatherforecast.service.impl;

import fr.nextoo.weatherforecast.api.service.ForecastServiceApi;
import fr.nextoo.weatherforecast.dto.ListDto;
import fr.nextoo.weatherforecast.dto.WeatherDto;
import fr.nextoo.weatherforecast.service.RainyDaysService;
import fr.nextoo.weatherforecast.service.util.MappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RainyDaysServiceIpml implements RainyDaysService {

    @Autowired
    public ForecastServiceApi forecastServiceApi;
    @Autowired
    public MappingUtility mappingUtility;

    @Override
    public List<Boolean> getRainyDaysByCity(String nomVille) {
        List<ListDto> listDtoList = mappingUtility.getMappedListList(forecastServiceApi.getForecastByCity(nomVille).getList());
        Map<String, List<WeatherDto>> weatherDto = new HashMap<>();
        for (ListDto listDto : listDtoList) {
            weatherDto.put(listDto.getDateTime(), listDto.getWeather());
        }
        List<WeatherDto> total = weatherDto.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        List<Boolean> jour = total.stream()
                .filter(WeatherDto::getIlPleut)
                .map(WeatherDto::getIlPleut)
                .collect(Collectors.toList());

        return jour;
    }
}
