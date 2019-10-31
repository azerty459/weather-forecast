package fr.nextoo.weatherforecast.service;

import fr.nextoo.weatherforecast.dto.WeatherDto;

import java.util.List;

public interface WeatherService<T> {

    public List<WeatherDto> getWeatherByCity(String ville);
}
