package fr.nextoo.weatherforecast.service.api.mapping;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;

import fr.nextoo.weatherforecast.bean.DailyForecastBean;
import fr.nextoo.weatherforecast.bean.ForecastBean;
import fr.nextoo.weatherforecast.service.api.dto.AtmosphereDto;
import fr.nextoo.weatherforecast.service.api.dto.ForecastDto;
import fr.nextoo.weatherforecast.service.api.dto.SkyDto;
import fr.nextoo.weatherforecast.utils.DateUtils;

public class ForecastMapping {

	/**
	 * Map Forecast Dto list to DailyBean list
	 * @param forecastsDto
	 * @return DailyForecastBean list
	 */
	public static List<DailyForecastBean> mappingForecastsDtoListToDailyForecastBeanList(List<ForecastDto> forecastsDto) {
		if (CollectionUtils.isEmpty(forecastsDto)) {
			return Collections.emptyList();
		}

		// map forecasts Dto list to Bean list
		List<ForecastBean> forecastsBean = mappingForecastsDtoListToBeanList(forecastsDto);

		// construct a Map
		// key   -> day
		// value -> forecasts of the day
		Map<LocalDate, List<ForecastBean>> forecastsByDay = forecastsBean
				.stream()
				.collect(Collectors.groupingBy(
						forecast -> DateUtils.formattingInstantToLocalDate(forecast.getInstant()) ));

		// convert the Map forecastByDay into a DailyForecastBean list
		return forecastsByDay
				.entrySet()
				.stream()
				.map(m->new DailyForecastBean(m.getKey(), m.getValue()))
				.collect(Collectors.toList());
	}

	/**
	 * Map Forecast Dto list to Bean list
	 * @param forecastsDto
	 * @return ForecastBean list
	 */
	private static List<ForecastBean> mappingForecastsDtoListToBeanList(List<ForecastDto> forecastsDto) {
		return forecastsDto.stream()
				.map(ForecastMapping::mappingForecastDtoToBean)
				.collect(Collectors.toList());
	}

	/**
	 * Map Forecast Dto to Bean
	 * @param forecastDto
	 * @return ForecastBean
	 */
	private static ForecastBean mappingForecastDtoToBean(ForecastDto forecastDto) {
		ForecastBean forecast = new ForecastBean();
		forecast.setInstant(forecastDto.getInstant());
		// TODO Optional
		AtmosphereDto atmosphereDto = forecastDto.getAtmosphere();
		if (atmosphereDto != null) {
			forecast.setTemperature(atmosphereDto.getTemperature());
			forecast.setHumidity(atmosphereDto.getHumidity());
		}
		// TODO Optional
		List<SkyDto> skyDto = forecastDto.getSky();
		if(skyDto != null && skyDto.size() > 0) {
			forecast.setWeatherName(skyDto.get(0).getMain());
			forecast.setWeatherDescription(skyDto.get(0).getDescription());
		}
		forecast.setRain(forecastDto.getRain());

		return forecast;
	}

}
