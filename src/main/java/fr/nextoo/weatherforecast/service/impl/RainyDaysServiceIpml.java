package fr.nextoo.weatherforecast.service.impl;

import fr.nextoo.weatherforecast.api.service.ForecastServiceApi;
import fr.nextoo.weatherforecast.dto.ListDto;
import fr.nextoo.weatherforecast.dto.WeatherDto;
import fr.nextoo.weatherforecast.service.RainyDaysService;
import fr.nextoo.weatherforecast.service.util.MappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RainyDaysServiceIpml implements RainyDaysService {

    @Autowired
    public ForecastServiceApi forecastServiceApi;
    @Autowired
    public MappingUtility mappingUtility;

    @Override
    public List<String> getRainyDaysByCity(String nomVille) {
        List<ListDto> listDtoList = mappingUtility.getMappedListList(forecastServiceApi.getForecastByCity(nomVille).getList());
        Map<String, List<WeatherDto>> weatherDto = new HashMap<>();
        for (ListDto listDto : listDtoList) {
            weatherDto.put(listDto.getDateTime(), listDto.getWeather());
        }

        Map<String, List<WeatherDto>> result = weatherDto.entrySet().stream()
                .filter(i -> !i.getValue().isEmpty())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        i -> i.getValue().stream()
                                .filter(WeatherDto::getIlPleut)
                                .collect(Collectors.toList())));

        Map<String, List<WeatherDto>> rainyDays = result.entrySet().stream()
                .filter(i -> !i.getValue().isEmpty())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        i -> i.getValue().stream()
                                .filter(Objects::nonNull)
                                .collect(Collectors.toList())));

        return new ArrayList<>(rainyDays.keySet());
    }
}
