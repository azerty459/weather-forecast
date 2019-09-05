package fr.nextoo.weatherforecast.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
 
import fr.nextoo.weatherforecast.bean.ForecastBean;
import fr.nextoo.weatherforecast.service.business.WeatherService;

@RestController
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@GetMapping(value = "weather/forecast/{city}")
	public Map<String, List<ForecastBean>> daysWeatherByCity(@PathVariable String city) {
		return weatherService.getDaysWeatherByCity(city);
	}

	@GetMapping(value = "weather/forecast/hotest-day/{city}")
	public List<ForecastBean> hotestDayByCity(@PathVariable String city) {
		return weatherService.getHotestDayByCity(city);
	}
	
}
