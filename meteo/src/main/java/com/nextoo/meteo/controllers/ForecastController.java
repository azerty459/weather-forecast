package com.nextoo.meteo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nextoo.meteo.api.WeatherApi;
import com.nextoo.meteo.dto.ForecastWrapper;

@RestController
public class ForecastController {
	
	@Autowired
	private WeatherApi weatherApi;
	
	@GetMapping("/forecast/{city}")
	public ResponseEntity<ForecastWrapper> forecastCity(@PathVariable() String city) {
		return ResponseEntity.ok(weatherApi.forecastCity(city).orElseThrow(RuntimeException::new));
	}
	

}
