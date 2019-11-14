package com.nextoo.meteo.api;

import java.util.Optional;

import com.nextoo.meteo.api.dto.ForecastWrapper;

public interface WeatherApi {
	
	Optional<ForecastWrapper> forecastCity(String city);

}
