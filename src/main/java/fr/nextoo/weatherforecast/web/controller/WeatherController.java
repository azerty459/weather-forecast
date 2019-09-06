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
	 * @param cityName
	 * @return List<DailyForecastBean>
	 */
	@GetMapping(value = "/weather/forecast/{cityName}")
	public List<DailyForecastBean> daysWeatherByCity(@PathVariable String cityName) {
		return weatherService.getDaysWeatherByCity(cityName);
	}

	/**
	 * Get the weather of the hottest day of the next few days for a city
	 * @param cityName
	 * @return DailyForecastBean
	 */
	@GetMapping(value = "/weather/forecast/hottest-day/{cityName}")
	public  DailyForecastBean hotestDayByCity(@PathVariable String cityName) {
		return weatherService.getHottestDayByCity(cityName);
	}

	/**
	 * Get the weather the next few rainy days for a city
	 * @param cityName
	 * @return List<DailyForecastBean>
	 */
	@GetMapping(value="/weather/forecast/rainy-day/{cityName}")
	public List<DailyForecastBean> rainyDaysByCity(@PathVariable String cityName){
		return weatherService.getRainyDaysrByCity(cityName);
	}

}
