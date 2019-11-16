package com.nextoo.meteo.api;

import java.util.Optional;

import com.nextoo.meteo.api.dto.Forecast;
import com.nextoo.meteo.api.dto.ForecastWrapper;

public interface WeatherApi {
	
	Optional<Forecast> actualWeather(String city);

	Optional<ForecastWrapper> forecastCity(String city);
	
	Optional<ForecastWrapper> forecastAndNow(String city);


}
