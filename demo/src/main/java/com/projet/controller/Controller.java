package com.projet.controller;

import java.io.IOException;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projet.business.ServiceMeteo;
import com.projet.dto.*;

@RestController
@RequestMapping("/meteo/{city}")
public class Controller {
		
	@Autowired
	private ServiceMeteo serviceMeteo;
	
	@GetMapping("")
	public PrevisionCityDto getPrevisionCityDay(@PathVariable @NotNull String city) throws IOException{
		
		return serviceMeteo.getPrevisionCity(city);	
	}
	
	@GetMapping("/hottest")
	public HottestDay getHottestDay(@PathVariable @NotNull String city) {
		
		return serviceMeteo.getHottestDay(city);
	}
	
	@GetMapping("/rain")
	public List<DayDto> getRainyDays(@PathVariable @NotNull String city) {
		
		return serviceMeteo.getRainyDays(city);
	}
	
	@GetMapping("/humidity")
	public Humidity getHumidity(@PathVariable @NotNull String city) {
		
		return serviceMeteo.getHumidity(city);
	}
}
