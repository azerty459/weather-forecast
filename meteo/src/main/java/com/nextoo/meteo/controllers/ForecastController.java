package com.nextoo.meteo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nextoo.meteo.api.WeatherApi;
import com.nextoo.meteo.api.dto.ForecastWrapper;
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
	

}
