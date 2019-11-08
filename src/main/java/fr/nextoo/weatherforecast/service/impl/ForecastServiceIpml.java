package fr.nextoo.weatherforecast.service.impl;

import fr.nextoo.weatherforecast.api.dto.PrevisionApiDto;
import fr.nextoo.weatherforecast.api.service.ForecastServiceApi;
import fr.nextoo.weatherforecast.dto.ForecastDto;
import fr.nextoo.weatherforecast.dto.MainDto;
import fr.nextoo.weatherforecast.dto.PrevisionDto;
import fr.nextoo.weatherforecast.dto.WeatherDto;
import fr.nextoo.weatherforecast.service.ForecastService;
import fr.nextoo.weatherforecast.service.util.MappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ForecastServiceIpml implements ForecastService {

    @Autowired
    public ForecastServiceApi forecastServiceApi;
    @Autowired
    public MappingUtility mappingUtility;

    @Override
    public ForecastDto getForecastByCity(String nomVille) {
        return mappingUtility.getMappedForecastData(forecastServiceApi.getForecastByCity(nomVille));
    }

    @Override
    public MainDto getActualHumidity(String nomVille) {
        MainDto mainDto = new MainDto();
        List<PrevisionDto> listDtoPrevision = mappingUtility.getMappedListList(forecastServiceApi.getForecastByCity(nomVille).getList());
        List<MainDto> mainDtoList = new LinkedList<>();
        for (PrevisionDto previsionDto : listDtoPrevision) {
            mainDtoList.add(previsionDto.getListMain());
        }

        Integer actualHumidity = mainDtoList.stream()
                .findFirst()
                .map(MainDto::getTauxHumidite)
                .get();
        mainDto.setTauxHumidite(actualHumidity);
        return mainDto;
    }

    @Override
    public PrevisionDto getHotestDayInWeekByCity(String nomVille) {
        PrevisionDto prevision = new PrevisionDto();
        List<PrevisionApiDto> list = forecastServiceApi.getForecastByCity(nomVille).getList();
        list.stream()
                .map(mappingUtility::getMappedListData)
                .getClass();
        ;
        List<PrevisionDto> listDtoPrevision = mappingUtility.getMappedListList(list);
        Map<String, Integer> tempMax = new HashMap<>();
        for (PrevisionDto previsionDto : listDtoPrevision) {
            tempMax.put(previsionDto.getDateTime(), previsionDto.getListMain().getTemperature_max());
        }
        prevision.setDateTime(Collections.max(tempMax.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey());
        return prevision;
    }

    @Override
    public List<String> getRainyDaysByCity(String nomVille) {
        List<PrevisionDto> listDtoPrevision = mappingUtility.getMappedListList(forecastServiceApi.getForecastByCity(nomVille).getList());
        Map<String, List<WeatherDto>> weatherDto = new HashMap<>();
        for (PrevisionDto previsionDto : listDtoPrevision) {
            weatherDto.put(previsionDto.getDateTime(), previsionDto.getWeather());
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
