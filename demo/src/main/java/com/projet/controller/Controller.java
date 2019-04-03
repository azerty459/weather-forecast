package com.projet.controller;

import java.io.IOException;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projet.dto.FcstDayDto;
import com.projet.dto.MeteoCityDto;
import servicesMeteo.ServiceMeteo;

@RestController
public class Controller {
		
	private ServiceMeteo monService = new ServiceMeteo();

	@RequestMapping("/meteo/{city}")
	public MeteoCityDto getMeteoDay(@PathVariable @NotNull String city) throws IOException{
		
		return monService.getMeteoCity(city);	
	}
	
	@RequestMapping("/meteo/{city}/hotest")
	public FcstDayDto getHotestDay(@PathVariable @NotNull String city) {
		
		return monService.getHotestDayOfWeek(city);
	}
	
	@RequestMapping("/meteo/{city}/rain")
	public List<FcstDayDto> getRainDay(@PathVariable @NotNull String city) {
		
		return monService.getDaysOfRain(city);
	}
}
 