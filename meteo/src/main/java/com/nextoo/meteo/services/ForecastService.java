package com.nextoo.meteo.services;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.nextoo.meteo.dto.NextooForecast;
import com.nextoo.meteo.dto.NextooForecastWrapper;
import com.nextoo.meteo.dto.NextooHumidityForecast;


public interface ForecastService {

	Optional<NextooForecastWrapper> forecastCity(String city);
	
	Optional<NextooForecast> hotestDay(String city);
		
	Optional<NextooForecastWrapper> rainingDays(String city);

	Optional<NextooHumidityForecast> humidityAnalyse(String city);

	
}
