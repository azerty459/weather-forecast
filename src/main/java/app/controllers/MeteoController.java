package app.controllers;

import java.util.List;

import javax.validation.constraints.NotNull;

import app.services.api.dto.CityDTO;
import app.services.api.dto.ForecastDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.services.api.MeteoService;
import app.services.api.entity.City;
import app.services.api.entity.Forecast;
import javafx.util.Pair;

@RestController
@RequestMapping("/meteo")
public class MeteoController {
	
	@Autowired
	MeteoService meteoService;

	@GetMapping("/city/{cityName}")
		public CityDTO getCity(@PathVariable(value="cityName") @NotNull String name) {
			return meteoService.getCity(name);
	    }
	
	@GetMapping("city/{cityName}/hottest")
		public String getHottestDayOftheWeek(@PathVariable(value="cityName") @NotNull String name) {
			return meteoService.getHottestDay(name);
		}

	
	@GetMapping("city/{cityName}/rainDays")
		public List<ForecastDTO> rainDays(@PathVariable(value="cityName") @NotNull String name) {
			return meteoService.rainDays(name);
	}
	
	@GetMapping("city/{cityName}/avgHumidity")
		public Pair<Double, Double> avgHumidity(@PathVariable("cityName") @NotNull String name) {
		return meteoService.avgHumi(name);
	}

	
}
