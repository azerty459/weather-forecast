package com.nextoo.meteo.api;

import java.util.Optional;

import com.nextoo.meteo.api.dto.ForecastDto;
import com.nextoo.meteo.api.dto.ForecastWrapperDto;

public interface WeatherApi {
	
	Optional<ForecastDto> actualWeather(String city);

	Optional<ForecastWrapperDto> forecastCity(String city);
	
	Optional<ForecastWrapperDto> forecastAndNow(String city);
	
}
