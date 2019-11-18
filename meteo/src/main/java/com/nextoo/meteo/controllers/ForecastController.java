package com.nextoo.meteo.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nextoo.meteo.dto.NextooForecast;
import com.nextoo.meteo.dto.NextooForecastWrapper;
import com.nextoo.meteo.dto.NextooHumidityForecast;
import com.nextoo.meteo.services.ForecastService;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
public class ForecastController {

	@Autowired
	private ForecastService forecastService;

	@GetMapping("/forecast/{city}")
	public ResponseEntity<NextooForecastWrapper> forecastCity(@PathVariable() String city) {
		return ResponseEntity.of(forecastService.forecastCity(city));
	}

	@GetMapping("/forecast/{city}/hotest")
	public ResponseEntity<NextooForecast> hotestDay(@PathVariable() String city) {
		return ResponseEntity.of(forecastService.hotestDay(city));
	}

	@GetMapping("/forecast/{city}/raining")
	public ResponseEntity<List<String>> rainyDay(@PathVariable() String city) {
		return ResponseEntity.of(forecastService.rainingDays(city));
	}

	@GetMapping("/forecast/{city}/humidity")
	public ResponseEntity<NextooHumidityForecast> humidityAnalyse(@PathVariable() String city) {
		return ResponseEntity.of(forecastService.humidityAnalyse(city));
	}

}
