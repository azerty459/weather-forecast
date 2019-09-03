package fr.nextoo.weatherforecast.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.nextoo.weatherforecast.bean.WeatherBean;
import fr.nextoo.weatherforecast.service.business.WeatherService;

@RestController
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	/**
	 * get the current weather by city
	 * @param city
	 * @return weather
	 */
//	@RequestMapping(value="/Weather/{city}", method=RequestMethod.GET)
	@GetMapping(value="/weather/{city}")
	public WeatherBean currentWeather(@PathVariable String city) {
		WeatherBean weather = weatherService.getWeatherByCity(city);
		return weather;
	}
	
}
