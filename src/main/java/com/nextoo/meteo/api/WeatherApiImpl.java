package com.nextoo.meteo.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nextoo.meteo.api.dto.ForecastDto;
import com.nextoo.meteo.api.dto.ForecastWrapperDto;

@Component
public class WeatherApiImpl implements WeatherApi {

	private static final String API_WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?units=metric&lang=fr&APPID=b24b0cd28ca1d04f4ad4cfb0616eabef";

	private static final String API_FORECAST_URL = "http://api.openweathermap.org/data/2.5/forecast?units=metric&lang=fr&APPID=b24b0cd28ca1d04f4ad4cfb0616eabef";

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public Optional<ForecastDto> actualWeather(String city) {
		ResponseEntity<String> response = restTemplate.getForEntity(API_WEATHER_URL + "&q=" + city , String.class);
		try {
			return Optional.of(objectMapper.readValue(response.getBody(), ForecastDto.class));
		} catch (JsonProcessingException e) {
			return Optional.empty();
		}
	}

	@Override
	public Optional<ForecastWrapperDto> forecastCity(String city) {
		ResponseEntity<String> response = restTemplate.getForEntity(API_FORECAST_URL + "&q=" + city , String.class);
		try {
			return Optional.of(objectMapper.readValue(response.getBody(), ForecastWrapperDto.class));
		} catch (JsonProcessingException e) {
			return Optional.empty();
		}
	}
	
	@Override
	public Optional<ForecastWrapperDto> forecastAndNow(String city) {
		Optional<ForecastDto> now = actualWeather(city);
		Optional<ForecastWrapperDto> forecast = forecastCity(city);
		
		if (!now.isPresent() || !forecast.isPresent() || forecast.get().getCode() != 200) {
			return Optional.empty();
		}
		
		forecast.get().setActually(now.get());
		return forecast;
	}

}
