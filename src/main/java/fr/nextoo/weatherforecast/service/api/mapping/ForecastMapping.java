package fr.nextoo.weatherforecast.service.api.mapping;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.nextoo.weatherforecast.bean.ForecastBean;
import fr.nextoo.weatherforecast.service.api.dto.AtmosphereDto;
import fr.nextoo.weatherforecast.service.api.dto.ForecastDto;

public class ForecastMapping {

	public static Map<String, List<ForecastBean>> mappingForecastDtoToDailyForecastBean(List<ForecastDto> forecastsDto) {
		Map<String, List<ForecastBean>> forecastsBeanByDate = new HashMap<>();

		if (forecastsDto != null) {
			List<ForecastBean> forecastsBean = mappingForecastDtoToForecastBean(forecastsDto);

			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

			forecastsBeanByDate = forecastsBean.stream()
					.collect(
							Collectors.groupingBy(forecast -> dateFormatter
									.format(LocalDateTime.ofInstant(forecast.getDate(), ZoneId.systemDefault()))));
		}
		return forecastsBeanByDate;
	}

	public static List<ForecastBean> mappingForecastDtoToForecastBean(List<ForecastDto> forecastsDto) {

		List<ForecastBean> forecastsBean = forecastsDto.stream()
				.map(forecastDto -> {
					ForecastBean forecast = new ForecastBean();
					forecast.setDate(forecastDto.getDate());

					AtmosphereDto atmosphereDto = forecastDto.getAtmosphere();
					if (atmosphereDto != null) {
						forecast.setTemperature(atmosphereDto.getTemperature());
					}
					return forecast;
				})
				.collect(Collectors.toList());

		return forecastsBean;

	}

	//	/**
	//	 * convert ForecastDto to ForecastBean
	//	 *
	//	 * @param forecastDto
	//	 * @return forecastBean
	//	 */
	//	public static ForecastBean mappingForecastDtoToForecastBean(ForecastDto forecastDto) {
	//		ForecastBean forecastBean = new ForecastBean();
	//
	//		if (forecastDto != null) {
	//			CityDto cityDto = forecastDto.getCity();
	//			forecastBean.setCity(mappingCityDtoToCityBean(cityDto));
	//
	//			List<WeatherDto> weatherDtoList = (LinkedList<WeatherDto>)forecastDto.getWeatherDays();
	//			forecastBean.setWeatherDays(mappingWeatherDtoListToWeatherBeanList(weatherDtoList));
	//		}
	//		return forecastBean;
	//	}
	//
	//	public static List<WeatherBean> mappingWeatherDtoListToWeatherBeanList(List<WeatherDto> weatherDtoList) {
	//		List<WeatherBean> weatherBeanList = new LinkedList<>();
	//
	//		if (weatherDtoList != null && weatherDtoList.size() > 0) {
	//			for (WeatherDto weatherDto : weatherDtoList) {
	//				WeatherBean weatherBean = mappingWeatherDtoToWeatherBean(weatherDto);
	//				weatherBeanList.add(weatherBean);
	//			}
	//		}
	//		return weatherBeanList;
	//	}
	//
	//	public static WeatherBean mappingWeatherDtoToWeatherBean(WeatherDto weatherDto) {
	//		WeatherBean weatherBean = new WeatherBean();
	//
	//		List<SkyDto> skyDtoList = weatherDto.getSky();
	//		if (skyDtoList != null) {
	//			List<SkyBean> skyBeanList = mappingSkyDtoListToSkyBeanList(skyDtoList);
	//			weatherBean.setSky(skyBeanList);
	//		}
	//		weatherBean.setDateTime(weatherDto.getDateTime());
	//		return weatherBean;
	//	}
	//
	//	public static List<SkyBean> mappingSkyDtoListToSkyBeanList(List<SkyDto> skyDtoList) {
	//		List<SkyBean> skyBeanList = new ArrayList<>();
	//
	//		for (SkyDto skyDto : skyDtoList) {
	//			SkyBean skyBean = mappingSkyDtoToSkyBean(skyDto);
	//			skyBeanList.add(skyBean);
	//		}
	//		return skyBeanList;
	//	}
	//
	//	public static SkyBean mappingSkyDtoToSkyBean(SkyDto skyDto) {
	//		SkyBean skyBean = new SkyBean();
	//
	//		if(skyDto != null) {
	//			skyBean.setMain(skyDto.getMain());
	//			skyBean.setDescription(skyDto.getDescription());
	//		}
	//		return skyBean;
	//	}
	//
	//	public static CityBean mappingCityDtoToCityBean(CityDto cityDto) {
	//		CityBean cityBean = new CityBean();
	//
	//		if (cityDto != null) {
	//			cityBean.setId(cityDto.getId());
	//			cityBean.setName(cityDto.getName());
	//		}
	//		return cityBean;
	//	}
}
