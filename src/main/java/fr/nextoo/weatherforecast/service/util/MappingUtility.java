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
        forecastDto.setDetailForecast(getMappedPrevisionList(forecastApiDto.getList()));
        return forecastDto;
    }

    public CityDto getMappedCityData(ForecastApiDto forecastApiDto) {
        CityDto cityDto = new CityDto();
        CityApiDto cityApiDto = forecastApiDto.getCity();
        cityDto.setNomVille(cityApiDto.getName());
        return cityDto;
    }

    public PrevisionDto getMappedPrevisionData(PrevisionApiDto previsionApiDto) {
        PrevisionDto previsionDto;
        Instant dateTime = previsionApiDto.getDt();
        DetailPrevisionApiDto detailPrevisionApiDto = previsionApiDto.getListDetailPrevision();
        List<WeatherApiDto> weatherApiDtoList = previsionApiDto.getWeather();
        RainApiDto rainApiDto = previsionApiDto.getRain();
        previsionDto = new PrevisionDto();
        previsionDto.setDateTime(utility.formatter(dateTime));
        previsionDto.setListDetailPrevision(getMappedDetailPrevisionData(detailPrevisionApiDto));
        previsionDto.setWeather(getMappedWeatherList(weatherApiDtoList));
        previsionDto.setRain(getMappedRainData(rainApiDto));
        return previsionDto;
    }

    public List<PrevisionDto> getMappedPrevisionList(List<PrevisionApiDto> listApiDtoPrevision) {
        List<PrevisionDto> detailForecastList = new LinkedList<>();
        for (PrevisionApiDto previsionApiDto : listApiDtoPrevision) {
            detailForecastList.add(getMappedPrevisionData(previsionApiDto));
        }
        return detailForecastList;
    }

    public WeatherDto getMappedWeatherData(WeatherApiDto weatherApiDto) {
        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setDescription(weatherApiDto.getDescription());
        weatherDto.setIsRainning(weatherApiDto.getDescription().contains("rain"));
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
        rainDto.setTauxPrecipitation(rainApiDto.getTauxPrecipitation());
        return rainDto;
    }

    public DetailPrevisionDto getMappedDetailPrevisionData(DetailPrevisionApiDto detailPrevisionApiDto) {
        DetailPrevisionDto detailPrevisionDto = new DetailPrevisionDto();
        detailPrevisionDto.setTemperature_max(detailPrevisionApiDto.getTemp_max().intValue());
        detailPrevisionDto.setTauxHumidite(detailPrevisionApiDto.getHumidity().intValue());
        return detailPrevisionDto;
    }
}
