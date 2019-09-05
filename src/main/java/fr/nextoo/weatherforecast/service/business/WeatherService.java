package fr.nextoo.weatherforecast.service.business;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.nextoo.weatherforecast.bean.ForecastBean;
import fr.nextoo.weatherforecast.service.api.WeatherServiceApi;

@Service
public class WeatherService {

	@Autowired
	private WeatherServiceApi weatherServiceApi;

	public Map<String, List<ForecastBean>> getDaysWeatherByCity(String city) {
		return weatherServiceApi.getDailyForecastsByCity(city);
	}

	public List<ForecastBean> getHotestDayByCity(String city) {
		List<ForecastBean> forecastsBean = weatherServiceApi.getForecastsByCity(city);

		Comparator<ForecastBean> comparingHotestTemperature = Comparator.comparing(ForecastBean::getTemperature);
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

		String hotestForecast = forecastsBean.stream()
				.max(comparingHotestTemperature)
				.map(forecast -> dateFormatter.format(LocalDateTime.ofInstant(forecast.getDate(), ZoneId.systemDefault())))
				.get();

		List<ForecastBean> forecastsOfHotestDay = forecastsBean.stream()
				.filter(forecast -> dateFormatter
						.format(LocalDateTime.ofInstant(forecast.getDate(), ZoneId.systemDefault()))
						.equals(hotestForecast))
				.collect(Collectors.toList());

		return forecastsOfHotestDay;
	}

}
