package fr.nextoo.weatherforecast.service.business;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.nextoo.weatherforecast.bean.WeatherBean;
import fr.nextoo.weatherforecast.service.api.WeatherServiceApi;
import fr.nextoo.weatherforecast.service.api.dto.WeatherDto;
import fr.nextoo.weatherforecast.service.mapping.ForecastMapping;

@Service
public class WeatherService {

	@Autowired
	private WeatherServiceApi weatherServiceApi;

	public List<WeatherBean> getDaysWeatherByCity(String city) {
		List<WeatherDto> weatherDtoList = weatherServiceApi.getWeatherDaysByCity(city);
		return ForecastMapping.mappingWeatherDtoListToWeatherBeanList(weatherDtoList);
	}

	public List<WeatherBean> getHotestDayByCity(String city) {
		List<WeatherDto> weatherDtoList = weatherServiceApi.getWeatherDaysByCity(city);

		List<WeatherDto> weatherDtoListOfHotestDay = new LinkedList<>();
		
		Comparator<WeatherDto> comparingHotestTemperature = Comparator.comparing(
				WeatherDto::getAtmosphere,
				(atmos1, atmos2) -> Double.compare(atmos1.getTemperature(), atmos2.getTemperature()));
		WeatherDto test = weatherDtoList.stream()
				.max(comparingHotestTemperature)
				.get();
				
		return ForecastMapping.mappingWeatherDtoListToWeatherBeanList(weatherDtoListOfHotestDay);
	}
	
}
