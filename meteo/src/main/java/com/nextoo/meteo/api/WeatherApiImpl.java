package com.nextoo.meteo.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nextoo.meteo.api.dto.Forecast;
import com.nextoo.meteo.api.dto.ForecastWrapper;

@Component
public class WeatherApiImpl implements WeatherApi {

	private static final String API_WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?units=metric&lang=fr&APPID=b24b0cd28ca1d04f4ad4cfb0616eabef";

	private static final String API_FORECAST_URL = "http://api.openweathermap.org/data/2.5/forecast?units=metric&lang=fr&APPID=b24b0cd28ca1d04f4ad4cfb0616eabef";

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public Optional<Forecast> actualWeather(String city) {
		ResponseEntity<String> response = restTemplate.getForEntity(API_WEATHER_URL + "&q=" + city , String.class);
		try {
			return Optional.of(objectMapper.readValue(response.getBody(), Forecast.class));
		} catch (JsonProcessingException e) {
			return Optional.empty();
		}
	}

	@Override
	public Optional<ForecastWrapper> forecastCity(String city) {
		ResponseEntity<String> response = restTemplate.getForEntity(API_FORECAST_URL + "&q=" + city , String.class);
		try {
			return Optional.of(objectMapper.readValue(response.getBody(), ForecastWrapper.class));
		} catch (JsonProcessingException e) {
			return Optional.empty();
		}
	}
	
	@Override
	public Optional<ForecastWrapper> forecastAndNow(String city) {
		Optional<Forecast> now = actualWeather(city);
		Optional<ForecastWrapper> forecast = forecastCity(city);
		
		if (now.isEmpty() || forecast.isEmpty() || forecast.get().getCode() != 200) {
			return Optional.empty();
		}
		
		forecast.get().setActually(now.get());
		return forecast;
	}

}
