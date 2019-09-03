package fr.nextoo.weatherforecast.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.nextoo.weatherforecast.bean.WeatherBean;
import fr.nextoo.weatherforecast.dto.WeatherDto;
import fr.nextoo.weatherforecast.service.api.WeatherServiceApi;
import fr.nextoo.weatherforecast.service.mapping.WeatherMapping;

@Service
public class WeatherService {

	@Autowired
	private WeatherServiceApi weatherServiceApi;
	
	/**
	 * 
	 * @param city
	 * @return
	 */
	public WeatherBean getWeatherByCity(String city) {
		WeatherDto weatherDto = weatherServiceApi.getCurrentWeatherByCity(city);
		return WeatherMapping.mappingWeatherDtoToWeatherBean(weatherDto);
	}
	
}
