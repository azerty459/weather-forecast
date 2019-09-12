package fr.nextoo.weatherforecast.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.nextoo.weatherforecast.service.business.WeatherService;
import fr.nextoo.weatherforecast.web.bean.DayForecastBean;
import fr.nextoo.weatherforecast.web.bean.ForecastsDetailsBean;

@CrossOrigin(origins = "http://localhost:8080")
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
	public List<ForecastsDetailsBean> weatherForecastsDaysList(@PathVariable String cityName) {
		return weatherService.getWeatherForecastsDaysList(cityName);
	}
	
	@GetMapping(value = "weather/{cityName}")
	public DayForecastBean weatherDay(@PathVariable String cityName) {
		return weatherService.getWeatherDay(cityName);
	}

	@GetMapping(value = "weather/detail/{cityName}")
	public ForecastsDetailsBean weatherDayDetailed(@PathVariable String cityName) {
		return weatherService.getWeatherDayDetailed(cityName);
	}
	
	/**
	 * Get the weather of the hottest day of the next few days for a city
	 * @param cityName
	 * @return DailyForecastBean
	 */
	@GetMapping(value = "/weather/forecast/hottest-day/{cityName}")
	public  ForecastsDetailsBean dayHottest(@PathVariable String cityName) {
		return weatherService.getDayHottest(cityName);
	}

	/**
	 * Get the weather the next few rainy days for a city
	 * @param cityName
	 * @return List<DailyForecastBean>
	 */
	@GetMapping(value="/weather/forecast/rainy-day/{cityName}")
	public List<ForecastsDetailsBean> daysListRain(@PathVariable String cityName){
		return weatherService.getDaysListRain(cityName);
	}

	/**
	 * Get the current humidity value for a city
	 * @param cityName
	 * @return
	 */
	@GetMapping(value="/weather/humidity/{cityName}")
	public Integer dayHumidityNow(@PathVariable String cityName){
		return weatherService.getDayHumidityNow(cityName);
	}

	/**
	 * Get the list of humidity average of the few next days for a city
	 * @param cityName
	 * @return
	 */
	@GetMapping(value="/weather/forecast/humidity-average/{cityName}")
	public Object humidityAverageByDay(@PathVariable String cityName) {
		return weatherService.getHumidityAverageByDay(cityName);
	}

}
