package fr.nextoo.weatherforecast.service.impl;

import fr.nextoo.weatherforecast.api.service.ForecastServiceApi;
import fr.nextoo.weatherforecast.dto.ListDto;
import fr.nextoo.weatherforecast.dto.MainDto;
import fr.nextoo.weatherforecast.service.ActualHumidityService;
import fr.nextoo.weatherforecast.service.util.MappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ActualHumidityServiceImpl implements ActualHumidityService {

    @Autowired
    public ForecastServiceApi forecastServiceApi;
    @Autowired
    public MappingUtility mappingUtility;

    @Override
    public Integer getActualHumidity(String nomVille) {
        List<ListDto> listDtoList = mappingUtility.getMappedListList(forecastServiceApi.getForecastByCity(nomVille).getList());
        List<MainDto> mainDtoList = new LinkedList<>();
        for (ListDto listDto : listDtoList) {
            mainDtoList.add(listDto.getListMain());
        }

        Integer actualHumidity = mainDtoList.stream()
                .findFirst()
                .map(MainDto::getTauxHumidite)
                .get();
        return actualHumidity;
    }
}
