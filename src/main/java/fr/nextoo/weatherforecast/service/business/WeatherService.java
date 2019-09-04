package fr.nextoo.weatherforecast.service.business;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.nextoo.weatherforecast.bean.DailyForecastBean;
import fr.nextoo.weatherforecast.bean.WeatherBean;
import fr.nextoo.weatherforecast.service.api.WeatherServiceApi;
import fr.nextoo.weatherforecast.service.api.dto.WeatherDto;

@Service
public class WeatherService {

	@Autowired
	private WeatherServiceApi weatherServiceApi;

	public DailyForecastBean getDaysWeatherByCity(String city) {
		return weatherServiceApi.getWeatherDaysByCity(city);
	}

	public DailyForecastBean getHotestDayByCity(String city) {
		DailyForecastBean weatherBeanList = weatherServiceApi.getWeatherDaysByCity(city);

		List<WeatherDto> weatherDtoListOfHotestDay = new LinkedList<>();
		
		Comparator<WeatherBean> comparingHotestTemperature = Comparator.comparing(
				WeatherBean::getAtmosphere,
				(atmos1, atmos2) -> Double.compare(atmos1.getTemperature(), atmos2.getTemperature()));
		
//		WeatherBean test = weatherBeanList.stream()
//				.max(comparingHotestTemperature)
//				.get();
				
		return weatherBeanList;
	}
	
}
