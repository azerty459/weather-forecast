package fr.nextoo.weatherforecast.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.nextoo.weatherforecast.bean.ForecastBean;
import fr.nextoo.weatherforecast.dto.ForecastDto;
import fr.nextoo.weatherforecast.service.api.WeatherServiceApi;
import fr.nextoo.weatherforecast.service.mapping.ForecastMapping;

@Service
public class WeatherService {

	@Autowired
	private WeatherServiceApi weatherServiceApi;

	public ForecastBean getDaysWeatherByCity(String city) {
		ForecastDto forecastDto = weatherServiceApi.getForecastByCity(city);
		return ForecastMapping.mappingForecastDtoToForecastBean(forecastDto);
	}
	
}
