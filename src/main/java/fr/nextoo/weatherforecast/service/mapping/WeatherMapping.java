package fr.nextoo.weatherforecast.service.mapping;

import fr.nextoo.weatherforecast.bean.WeatherBean;
import fr.nextoo.weatherforecast.dto.WeatherDto;

public class WeatherMapping {

	/**
	 * convert WeatherDto to WeatherBean
	 * @param weatherDto
	 * @return weather (bean)
	 */
	public static WeatherBean mappingWeatherDtoToWeatherBean(WeatherDto weatherDto) {
		WeatherBean weather = new WeatherBean();
		
		if (weatherDto != null) {
			weather.setId(weatherDto.getId());
			weather.setCity(weatherDto.getCity());
			weather.setTemperature(weatherDto.getTemperature());
			weather.setTemperatureMin(weatherDto.getTemperatureMin());
			weather.setTemperatureMax(weatherDto.getTemperatureMax());
			weather.setPressure(weatherDto.getPressure());
			weather.setHumidity(weatherDto.getHumidity());
		}
		
		return weather;
	}
}
