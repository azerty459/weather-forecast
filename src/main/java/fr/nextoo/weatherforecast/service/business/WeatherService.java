package fr.nextoo.weatherforecast.service.business;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

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
	 * @param city
	 * @return DailyForecastBean List
	 */
	public List<DailyForecastBean> getDaysWeatherByCity(String city) {
		return weatherServiceApi.getDailyForecastsByCity(city);
	}

	/**
	 * Get hottest DailyForecast of the next few days for a city
	 * @param city
	 * @return Hottest DailyForecastBean
	 */
	public  DailyForecastBean getHottestDayByCity(String city) {
		// get the dailyForecastList of Weather API
		List<DailyForecastBean> dailyForecastList = weatherServiceApi.getDailyForecastsByCity(city);

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
				.map(forecast -> DateUtils.formattingInstantToLocalDate(forecast.getDate()))
				.get();

		// return the DailyForecastBean with the day is equals of the hottestLocalDate
		return dailyForecastList
				.stream()
				.filter(daily -> daily.getDay().equals(hottestLocalDate))
				.findFirst()
				.orElse(new DailyForecastBean());
	}

}
