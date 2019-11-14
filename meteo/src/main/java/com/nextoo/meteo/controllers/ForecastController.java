package com.nextoo.meteo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForecastController {
	
	@GetMapping("/{city}")
	public void forecastCity(@RequestParam String city) {
		
	}
	

}
