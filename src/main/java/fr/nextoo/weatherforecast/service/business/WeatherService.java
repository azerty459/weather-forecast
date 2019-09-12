package fr.nextoo.weatherforecast.service.business;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.nextoo.weatherforecast.service.api.WeatherServiceApi;
import fr.nextoo.weatherforecast.utils.DateUtils;
import fr.nextoo.weatherforecast.web.bean.DayForecastBean;
import fr.nextoo.weatherforecast.web.bean.ForecastsDetailsBean;
import fr.nextoo.weatherforecast.web.bean.ForecastBean;

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
	private static final Comparator<ForecastBean> FORECAST_TEMPERATURE_COMPARATOR = Comparator.comparing(ForecastBean::getTemperature);

	/**
	 * DailyForecast Comparator by LocaleDate
	 */
	private static final Comparator<ForecastsDetailsBean> DAILY_FORECAST_COMPARATOR = Comparator.comparing(ForecastsDetailsBean::getDay);
	
	/**
	 * Get DailyForecast List of the next few days for a city
	 * @param cityName
	 * @return DailyForecastBean List
	 */
	public List<ForecastsDetailsBean> getWeatherForecastsDaysList(String cityName) {
		return weatherServiceApi.getDailyForecastsList(cityName);
	}
	
	public ForecastsDetailsBean getWeatherDayDetailed(String cityName) {
		List<ForecastsDetailsBean> dailyForecastsList = weatherServiceApi.getDailyForecastsList(cityName);
		
		return dailyForecastsList
				.stream()
				.min(DAILY_FORECAST_COMPARATOR)
				.get();
	}

	public DayForecastBean getWeatherDay(String cityName) {
		return weatherServiceApi.getCurrentWeather(cityName);
	}
	
	/**
	 * Get hottest DailyForecast of the next few days for a city
	 * @param cityName
	 * @return Hottest DailyForecastBean
	 */
	public  ForecastsDetailsBean getDayHottest(String cityName) {
		// get the dailyForecastList of Weather API
		List<ForecastsDetailsBean> dailyForecastsList = weatherServiceApi.getDailyForecastsList(cityName);

		// find the date of the hottest day
		LocalDate hottestLocalDate = dailyForecastsList
				.stream()
				// get the hottest forecast for each day
				.map(dailyForecast -> getHottestForecast(dailyForecast))
				// get the hottest day
				.max(FORECAST_TEMPERATURE_COMPARATOR)
				// get the date of the hottest day
				.map(forecast -> DateUtils.formattingInstantToLocalDate(forecast.getInstant()))
				.get();

		// return the DailyForecastBean with the day is equals of the hottestLocalDate
		return dailyForecastsList
				.stream()
				.filter(daily -> daily.getDay().equals(hottestLocalDate))
				.findFirst()
				.orElse(null);
	}

	private ForecastBean getHottestForecast(ForecastsDetailsBean dailyForecast) {
		return  dailyForecast.getForecasts()
				.stream()
				.max(FORECAST_TEMPERATURE_COMPARATOR)
				.get();
	}

	/**
	 * Get rainy DailyForecast of the next few days for a city
	 * @param cityName
	 * @return rainy DailyForecastBean list
	 */
	public List<ForecastsDetailsBean> getDaysListRain(String cityName) {
		// get the dailyForecastList of Weather API
		List<ForecastsDetailsBean> dailyForecastList = weatherServiceApi.getDailyForecastsList(cityName);

		// return rainy days
		// when a forecast in a day has rain != 0
		return dailyForecastList
				.stream()
				.filter(day -> isRainyDay(day) )
				.collect(Collectors.toList());

	}

	private boolean isRainyDay(ForecastsDetailsBean day) {
		return day.getForecasts()
				.stream()
				.anyMatch(forecast -> forecast.getRain() != 0);
	}

	/**
	 * Get current humidity for a city
	 * @param cityName
	 * @return humidity
	 */
	public Integer getDayHumidityNow(String cityName) {
		// get the currentForecast of Weather API
		DayForecastBean currentForecast = weatherServiceApi.getCurrentWeather(cityName);
		return currentForecast == null ? null : currentForecast.getHumidity();
	}

	/**
	 * Get humidity average of each next days for a city
	 * @param cityName
	 * @return list of humidity average
	 */
	public List<Double> getHumidityAverageByDay(String cityName) {
		// get the dailyForecastList of Weather API
		List<ForecastsDetailsBean> dailyForecastList = weatherServiceApi.getDailyForecastsList(cityName);

		return dailyForecastList
				.stream()
				// sort day by date
				.sorted(DAILY_FORECAST_COMPARATOR)
				// for each day, get the humidity average
				.map( day -> getHumidityAverage(day))
				// collect to list the values who existing
				.filter(OptionalDouble::isPresent)
				.map(OptionalDouble::getAsDouble)
				.collect(Collectors.toList());
	}

	private OptionalDouble getHumidityAverage(ForecastsDetailsBean day) {
		return day.getForecasts()
				.stream()
				.mapToInt(ForecastBean::getHumidity)
				.average();
	}

}
