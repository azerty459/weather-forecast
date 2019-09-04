package fr.nextoo.weatherforecast.service.mapping;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import fr.nextoo.weatherforecast.bean.CityBean;
import fr.nextoo.weatherforecast.bean.ForecastBean;
import fr.nextoo.weatherforecast.bean.SkyBean;
import fr.nextoo.weatherforecast.bean.WeatherBean;
import fr.nextoo.weatherforecast.dto.CityDto;
import fr.nextoo.weatherforecast.dto.ForecastDto;
import fr.nextoo.weatherforecast.dto.SkyDto;
import fr.nextoo.weatherforecast.dto.WeatherDto;

public class ForecastMapping {

	/**
	 * convert ForecastDto to ForecastBean
	 *
	 * @param forecastDto
	 * @return forecastBean
	 */
	public static ForecastBean mappingForecastDtoToForecastBean(ForecastDto forecastDto) {
		ForecastBean forecastBean = new ForecastBean();

		if (forecastDto != null) {

			CityDto cityDto = forecastDto.getCity();
			if (cityDto != null) {
				CityBean cityBean = new CityBean();
				cityBean.setId(cityDto.getId());
				cityBean.setName(cityDto.getName());
				forecastBean.setCity(cityBean);
			}

			WeatherDto[] weatherDaysDto = forecastDto.getWeatherDays();
			if (weatherDaysDto != null && weatherDaysDto.length > 0) {

				List<WeatherBean> weatherDaysBean = new LinkedList<>();

				for (WeatherDto weatherDto : weatherDaysDto) {
					WeatherBean weatherBean = new WeatherBean();

					List<SkyDto> skyDtoList = weatherDto.getSky();
					if (skyDtoList != null) {
						List<SkyBean> skyBeanList = new ArrayList<>();

						for (SkyDto skyDto : skyDtoList) {
							SkyBean skyBean = new SkyBean();
							skyBean.setMain(skyDto.getMain());
							skyBean.setDescription(skyDto.getDescription());
							skyBeanList.add(skyBean);
						}
						weatherBean.setSky(skyBeanList);
					}

					weatherDaysBean.add(weatherBean);
				}
				forecastBean.setWeatherDays(weatherDaysBean);
			}
		}

		return forecastBean;
	}
}
