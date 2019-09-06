package fr.nextoo.weatherforecast.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.nextoo.weatherforecast.bean.DailyForecastBean;
import fr.nextoo.weatherforecast.service.business.WeatherService;

@RestController
public class WeatherController {

	/**
	 * WeatherService injection
	 */
	@Autowired
	private WeatherService weatherService;

	/**
	 * Get the weather of the next few days for a city
	 * @param city
	 * @return List<DailyForecastBean>
	 */
	@GetMapping(value = "/weather/forecast/{city}")
	public List<DailyForecastBean> daysWeatherByCity(@PathVariable String city) {
		return weatherService.getDaysWeatherByCity(city);
	}

	/**
	 * Get the weather of the hottest day of the next few days for a city
	 * @param city
	 * @return DailyForecastBean
	 */
	@GetMapping(value = "weather/forecast/hottest-day/{city}")
	public  DailyForecastBean hotestDayByCity(@PathVariable String city) {
		return weatherService.getHottestDayByCity(city);
	}

}
