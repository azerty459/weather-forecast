package com.nextoo.meteo.controllers;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nextoo.meteo.api.WeatherApi;
import com.nextoo.meteo.api.dto.Forecast;
import com.nextoo.meteo.api.dto.ForecastWrapper;
import com.nextoo.meteo.dto.NextooForecast;
import com.nextoo.meteo.dto.NextooForecastWrapper;
import com.nextoo.meteo.exception.ApiException;
import com.nextoo.meteo.transformer.ForecastTransformer;

@RestController
public class ForecastController {

	@Autowired
	private WeatherApi weatherApi;

	@Autowired
	private ForecastTransformer forecastTransformer;

	@GetMapping("/forecast/{city}")
	public ResponseEntity<NextooForecastWrapper> forecastCity(@PathVariable() String city) throws ApiException {
		ForecastWrapper forecast = weatherApi.forecastCity(city).orElseThrow(ApiException::new);
		NextooForecastWrapper nextooForecast = forecastTransformer.toNextoo(forecast).orElseThrow(ApiException::new);
		nextooForecast.setVille(city);
		return ResponseEntity.ok(nextooForecast);
	}

	@GetMapping("/forecast/{city}/hotest")
	public ResponseEntity<NextooForecast> hotestDay(@PathVariable() String city) throws ApiException {
		ForecastWrapper forecast = weatherApi.forecastCity(city).orElseThrow(ApiException::new);
		Forecast hotest = forecast.getForcast().stream()
				.max(Comparator.comparing(f -> f.getWeatherInfo().getTemperature())).orElseThrow(ApiException::new);
		
		return ResponseEntity.ok(forecastTransformer.toNextoo(hotest));
	}
	
	@GetMapping("/forecast/{city}/raining")
	public ResponseEntity<NextooForecastWrapper> rainyDay(@PathVariable() String city) throws ApiException {
		ForecastWrapper forecast = weatherApi.forecastCity(city).orElseThrow(ApiException::new);
		List<Forecast> raining = forecast.getForcast().stream()
				.filter(f -> f.getWeather().stream().anyMatch(w -> w.getDescription().contains("pluie")))
				.collect(Collectors.toList());
		
		forecast.setForcast(raining);
		
		NextooForecastWrapper nextooForecast = forecastTransformer.toNextoo(forecast).orElseThrow(ApiException::new);
		nextooForecast.setVille(city);
		return ResponseEntity.ok(nextooForecast);
	}

}
