package fr.nextoo.weatherforecast.service.impl;

import fr.nextoo.weatherforecast.api.service.ForecastServiceApi;
import fr.nextoo.weatherforecast.dto.ListDto;
import fr.nextoo.weatherforecast.service.HotestDayInWeekService;
import fr.nextoo.weatherforecast.service.util.MappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HotestDayInWeekServiceImpl implements HotestDayInWeekService {

    @Autowired
    public ForecastServiceApi forecastServiceApi;
    @Autowired
    public MappingUtility mappingUtility;

    @Override
    public String getHotestDayInWeekByCity(String nomVille) {
        List<ListDto> listDtoList = mappingUtility.getMappedListList(forecastServiceApi.getForecastByCity(nomVille).getList());
        Map<String, Integer> tempMax = new HashMap<>();
        for (ListDto listDto : listDtoList) {
            tempMax.put(listDto.getDateTime(), listDto.getListMain().getTemperature_max());
        }
        return Collections.max(tempMax.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }
}