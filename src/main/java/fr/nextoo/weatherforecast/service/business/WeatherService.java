package fr.nextoo.weatherforecast.service.business;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.nextoo.weatherforecast.bean.DailyForecastBean;
import fr.nextoo.weatherforecast.bean.ForecastBean;
import fr.nextoo.weatherforecast.service.api.WeatherServiceApi;
import fr.nextoo.weatherforecast.utils.DateUtils;

@Service
public class WeatherService {

	/**
	 * Inject WeatherServiceApi
	 */
	@Autowired
	private WeatherServiceApi weatherServiceApi;

	/**
	 * ForecastBean Comparator by temperature
	 */
	private Comparator<ForecastBean> comparingHottestTemperature = Comparator.comparing(ForecastBean::getTemperature);

	/**
	 * Get DailyForecast List of the next few days for a city
	 * @param cityName
	 * @return DailyForecastBean List
	 */
	public List<DailyForecastBean> getDaysWeatherByCity(String cityName) {
		return weatherServiceApi.getDailyForecastsByCity(cityName);
	}

	/**
	 * Get hottest DailyForecast of the next few days for a city
	 * @param cityName
	 * @return Hottest DailyForecastBean
	 */
	public  DailyForecastBean getHottestDayByCity(String cityName) {
		// get the dailyForecastList of Weather API
		List<DailyForecastBean> dailyForecastList = weatherServiceApi.getDailyForecastsByCity(cityName);

		// find the date of the hottest day
		// first map()  -> get the hottest forecast for each day
		// second map() -> get the hottest day, by comparing the result of the previous value
		LocalDate hottestLocalDate = dailyForecastList
				.stream()
				.map(d -> d.getForecasts()
						.stream()
						.max(comparingHottestTemperature)
						.get())
				.max(comparingHottestTemperature)
				.map(forecast -> DateUtils.formattingInstantToLocalDate(forecast.getInstant()))
				.get();

		// return the DailyForecastBean with the day is equals of the hottestLocalDate
		return dailyForecastList
				.stream()
				.filter(daily -> daily.getDay().equals(hottestLocalDate))
				.findFirst()
				.orElse(new DailyForecastBean());
	}

	/**
	 * Get rainy DailyForecast of the next few days for a city
	 * @param cityName
	 * @return rainy DailyForecastBean list
	 */
	public List<DailyForecastBean> getRainyDaysByCity(String cityName) {
		// get the dailyForecastList of Weather API
		List<DailyForecastBean> dailyForecastList = weatherServiceApi.getDailyForecastsByCity(cityName);

		// return rainy days
		// when a forecast in a day has rain != 0
		return dailyForecastList
				.stream()
				.filter(day -> day.getForecasts()
						.stream()
						.anyMatch(forecast -> forecast.getRain() != 0) )
				.collect(Collectors.toList());

	}

	/**
	 * Get current humidity for a city
	 * @param cityName
	 * @return humidity
	 */
	public double getCurrentHumidityByCity(String cityName) {
		// get the currentForecast of Weather API
		ForecastBean currentForecast = weatherServiceApi.getCurrentWeatherByCity(cityName);
		return currentForecast.getHumidity();
	}

	/**
	 * Get humidity average of each next days for a city
	 * @param cityName
	 * @return list of humidity average
	 */
	public List<Double> getHumidityAverageByDayByCity(String cityName) {
		// get the dailyForecastList of Weather API
		List<DailyForecastBean> dailyForecastList = weatherServiceApi.getDailyForecastsByCity(cityName);

		// sort day by date
		// then for each day, get the humidity average
		// and collect to list the values who existing
		return dailyForecastList
				.stream()
				.sorted(Comparator.comparing(DailyForecastBean::getDay))
				.map( day -> day.getForecasts()
						.stream()
						.mapToInt(ForecastBean::getHumidity)
						.average()
						)
				.filter(OptionalDouble::isPresent)
				.map(OptionalDouble::getAsDouble)
				.collect(Collectors.toList());
	}

}
