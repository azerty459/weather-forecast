package com.nextoo.meteo.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nextoo.meteo.dto.ForecastWrapper;

@Component
public class WeatherApiImpl implements WeatherApi {

	private static final String API_URL = "http://api.openweathermap.org/data/2.5/forecast?units=metric&lang=fr&APPID=b24b0cd28ca1d04f4ad4cfb0616eabef";

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public Optional<ForecastWrapper> forecastCity(String city) {
		ResponseEntity<String> response = restTemplate.getForEntity(API_URL + "&q=" + city , String.class);
		try {
			return Optional.of(objectMapper.readValue(response.getBody(), ForecastWrapper.class));
		} catch (JsonProcessingException e) {
			return Optional.empty();
		}
	}

}
