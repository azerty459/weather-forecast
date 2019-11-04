package fr.nextoo.weatherforecast.service.util;

import fr.nextoo.weatherforecast.api.dto.*;
import fr.nextoo.weatherforecast.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class MappingUtility {

    @Autowired
    public Utility utility;

    public ForecastDto getMappedForecastData(ForecastApiDto forecastApiDto) {
        ForecastDto forecastDto = new ForecastDto();
        forecastDto.setVille(getMappedCityData(forecastApiDto));
        forecastDto.setDetailForecast(getMappedListList(forecastApiDto.getList()));
        return forecastDto;
    }

    public CityDto getMappedCityData(ForecastApiDto forecastApiDto) {
        CityDto cityDto = new CityDto();
        CityApiDto cityApiDto = forecastApiDto.getCity();
        cityDto.setNomVille(cityApiDto.getName());
        return cityDto;
    }

    public ListDto getMappedListData(ListApiDto listApiDto) {
        ListDto listDto;
        Instant dateTime = listApiDto.getDt();
        MainApiDto mainApiDto = listApiDto.getListMain();
        List<WeatherApiDto> weatherApiDtoList = listApiDto.getWeather();
        RainApiDto rainApiDto = listApiDto.getRain();
        listDto = new ListDto();
        listDto.setDateTime(utility.formatter(dateTime));
        listDto.setListMain(getMappedMainData(mainApiDto));
        listDto.setWeather(getMappedWeatherList(weatherApiDtoList));
        listDto.setRain(getMappedRainData(rainApiDto));
        return listDto;
    }

    public List<ListDto> getMappedListList(List<ListApiDto> listApiDtoList) {
        List<ListDto> detailForecastList = new LinkedList<>();
        for (ListApiDto listApiDto : listApiDtoList) {
            detailForecastList.add(getMappedListData(listApiDto));
        }
        return detailForecastList;
    }

    public WeatherDto getMappedWeatherData(WeatherApiDto weatherApiDto) {
        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setMain(weatherApiDto.getMain());
        weatherDto.setDescription(weatherApiDto.getDescription());
        weatherDto.setIlPleut(weatherApiDto.getDescription().contains("rain"));
        weatherDto.setIcon(weatherApiDto.getIcon());
        return weatherDto;
    }

    public List<WeatherDto> getMappedWeatherList(List<WeatherApiDto> weatherApiDtoList) {
        List<WeatherDto> weatherDtoList = new ArrayList<>();
        for (WeatherApiDto weatherApiDto : weatherApiDtoList) {
            weatherDtoList.add(getMappedWeatherData(weatherApiDto));
        }
        return weatherDtoList;
    }

    public RainDto getMappedRainData(RainApiDto rainApiDto) {
        RainDto rainDto = new RainDto();
        rainDto.setTauxPrecipitation(rainApiDto.get_3h());
        return rainDto;
    }

    public MainDto getMappedMainData(MainApiDto mainApiDto) {
        MainDto mainDto = new MainDto();
        mainDto.setTemperature(mainApiDto.getTemp().intValue());
        mainDto.setTemperature_min(mainApiDto.getTemp_min().intValue());
        mainDto.setTemperature_max(mainApiDto.getTemp_max().intValue());
        mainDto.setTauxHumidite(mainApiDto.getHumidity().intValue());
        return mainDto;
    }
}
