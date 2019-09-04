package fr.nextoo.weatherforecast.service.api.mapping;

import java.util.List;
import java.util.stream.Collectors;

import fr.nextoo.weatherforecast.bean.DailyForecastBean;
import fr.nextoo.weatherforecast.bean.ForecastBean;
import fr.nextoo.weatherforecast.service.api.dto.ForecastDto;
import fr.nextoo.weatherforecast.service.api.dto.SkyDto;
import fr.nextoo.weatherforecast.service.api.dto.WeatherDto;

public class ForecastMapping {

	public static DailyForecastBean mappingForecastDtoToDailyForecastBean(ForecastDto forecastDto) {
		DailyForecastBean dailyForecastBean = new DailyForecastBean();
		
		if(forecastDto != null) {
			List<WeatherDto> weatherDtoList = forecastDto.getWeatherDays();
			if(weatherDtoList != null && weatherDtoList.size() > 0) {
				dailyForecastBean.setDate(weatherDtoList.get(0).getDateTime());    
				
				weatherDtoList.stream()
				.map(weatherDto -> {
					List<SkyDto> skyDtoList = weatherDto.getSky();
					ForecastBean forecastBean = new ForecastBean();
					
					if (skyDtoList != null && skyDtoList.size() > 0) {
						SkyDto skyDto = skyDtoList.get(0);

						forecastBean = skyDtoList.stream().map(
								skyTemp -> {
								ForecastBean forecastTemp = new ForecastBean();
								forecastTemp.setWeatherName(skyTemp.getMain());
								forecastTemp.setWeatherDescription(skyTemp.getDescription());
								
								return forecastTemp;
								}).findFirst().get();
					
					}
					return forecastBean;
				})
				.collect(Collectors.toList());
			}
		}
		return dailyForecastBean;
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
