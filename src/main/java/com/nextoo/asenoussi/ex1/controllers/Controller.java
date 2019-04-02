package com.nextoo.asenoussi.ex1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextoo.asenoussi.ex1.entities.HumidityResponseDto;
import com.nextoo.asenoussi.ex1.entities.PrevisionDto;
import com.nextoo.asenoussi.ex1.entities.ResponseDto;
import com.nextoo.asenoussi.ex1.service.MeteoService;

@RestController
@RequestMapping("/meteo/")
public class Controller {

	@Autowired
	private MeteoService service;
	
	@GetMapping("/city/{cityName}")
	public ResponseDto test(@PathVariable("cityName") String cityName) {
		return service.getDataFromCityName(cityName);
	}
	
	@GetMapping("city/{cityName}/dayMostHot")
	public PrevisionDto mostHotDayOfWeek(@PathVariable("cityName") String cityName) {
		return service.getMostHotDayOfWeek(cityName);
	}
	
	@GetMapping("city/{cityName}/rainDay")
	public PrevisionDto[] rainDays(@PathVariable("cityName") String cityName) {
		return service.getDayWithRain(cityName);
	}
	
	@GetMapping("city/{cityName}/humidity")
	public HumidityResponseDto humidity(@PathVariable("cityName") String cityName) {
		return service.humidity(cityName);
	}
}
