package com.nextoo.asenoussi.ex1.controllers;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextoo.asenoussi.ex1.dto.HumidityResponseDto;
import com.nextoo.asenoussi.ex1.dto.ForecastDto;
import com.nextoo.asenoussi.ex1.dto.ResponseApiDto;
import com.nextoo.asenoussi.ex1.service.WeatherService;

@RestController
@RequestMapping("/weather/")
@CrossOrigin("*")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/city/{cityName}")
	public ResponseApiDto getAll(@PathVariable("cityName") @NotNull @NotEmpty String cityName) {
		return weatherService.getAllDataFromCityName(cityName);
	}
	
	@GetMapping("city/{cityName}/forecasts/mosthot")
	public ForecastDto mostHotDayOfWeek(@PathVariable("cityName") @NotNull @NotEmpty String cityName) {
		return weatherService.getMostHotDayOfWeek(cityName);
	}
	
	@GetMapping("city/{cityName}/forecasts/rain")
	public ForecastDto[] rainDays(@PathVariable("cityName") @NotNull @NotEmpty String cityName) {
		return weatherService.getDayWithRain(cityName);
	}
	
	@GetMapping("city/{cityName}/humidity")
	public HumidityResponseDto humidity(@PathVariable("cityName") @NotNull @NotEmpty String cityName) {
		return weatherService.getHumidityData(cityName);
	}
}
