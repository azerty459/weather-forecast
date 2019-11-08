package fr.nextoo.weatherforecast.service.impl;

import fr.nextoo.weatherforecast.api.dto.PrevisionApiDto;
import fr.nextoo.weatherforecast.api.service.ForecastServiceApi;
import fr.nextoo.weatherforecast.dto.ForecastDto;
import fr.nextoo.weatherforecast.dto.DetailPrevisionDto;
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
    public DetailPrevisionDto getActualHumidity(String nomVille) {
        DetailPrevisionDto detailPrevisionDto = new DetailPrevisionDto();
        List<PrevisionDto> listDtoPrevision = mappingUtility.getMappedPrevisionList(forecastServiceApi.getForecastByCity(nomVille).getList());
        List<DetailPrevisionDto> detailPrevisionDtoList = new LinkedList<>();
        for (PrevisionDto previsionDto : listDtoPrevision) {
            detailPrevisionDtoList.add(previsionDto.getListDetailPrevision());
        }

        Integer actualHumidity = detailPrevisionDtoList.stream()
                .findFirst()
                .map(DetailPrevisionDto::getTauxHumidite)
                .get();
        detailPrevisionDto.setTauxHumidite(actualHumidity);
        return detailPrevisionDto;
    }

    @Override
    public PrevisionDto getHotestDayInWeekByCity(String nomVille) {
        PrevisionDto prevision = new PrevisionDto();
        List<PrevisionApiDto> list = forecastServiceApi.getForecastByCity(nomVille).getList();
        list.stream()
                .map(mappingUtility::getMappedPrevisionData)
                .getClass();
        ;
        List<PrevisionDto> listDtoPrevision = mappingUtility.getMappedPrevisionList(list);
        Map<String, Integer> tempMax = new HashMap<>();
        for (PrevisionDto previsionDto : listDtoPrevision) {
            tempMax.put(previsionDto.getDateTime(), previsionDto.getListDetailPrevision().getTemperature_max());
        }
        prevision.setDateTime(Collections.max(tempMax.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey());
        return prevision;
    }

    @Override
    public List<String> getRainyDaysByCity(String nomVille) {
        List<PrevisionDto> listDtoPrevision = mappingUtility.getMappedPrevisionList(forecastServiceApi.getForecastByCity(nomVille).getList());
        Map<String, List<WeatherDto>> weatherDto = new HashMap<>();
        for (PrevisionDto previsionDto : listDtoPrevision) {
            weatherDto.put(previsionDto.getDateTime(), previsionDto.getWeather());
        }

        Map<String, List<WeatherDto>> result = weatherDto.entrySet().stream()
                .filter(i -> !i.getValue().isEmpty())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        i -> i.getValue().stream()
                                .filter(WeatherDto::getIsRainning)
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
