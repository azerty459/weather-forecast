package fr.nextoo.weatherforecast.service.api.mapping;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;

import fr.nextoo.weatherforecast.bean.CurrentForecastBean;
import fr.nextoo.weatherforecast.bean.DailyForecastBean;
import fr.nextoo.weatherforecast.bean.ForecastBean;
import fr.nextoo.weatherforecast.service.api.dto.CurrentForecastDto;
import fr.nextoo.weatherforecast.service.api.dto.ForecastDto;
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
		Optional<ForecastDto> forecastDtoOptional = Optional.ofNullable(forecastDto);

		if(forecastDtoOptional.isEmpty()) {
			return new ForecastBean();
		}

		ForecastBean forecast = new ForecastBean();
		forecast.setInstant(forecastDto.getInstant());

		forecastDtoOptional
		.map(ForecastDto::getAtmosphere)
		.ifPresent( atmosphereDto -> {
			forecast.setTemperature(atmosphereDto.getTemperature());
			forecast.setHumidity(atmosphereDto.getHumidity());
		});

		forecastDtoOptional
		.map(ForecastDto::getSky)
		.ifPresent( skyDtoList -> {
			skyDtoList.stream().findFirst().ifPresent( skyDto -> {
				forecast.setWeatherName(skyDto.getMain());
				forecast.setWeatherDescription(skyDto.getDescription());
			});
		});

		forecast.setRain(forecastDto.getRain());

		return forecast;
	}

	/**
	 * Map Current Forecast Dto to Bean
	 * @param currentForecastDto
	 * @return
	 */
	public static CurrentForecastBean mappingCurrentForecastDtoToBean(CurrentForecastDto forecastDto) {
		Optional<CurrentForecastDto> forecastDtoOptional = Optional.ofNullable(forecastDto);

		if(forecastDtoOptional.isEmpty()) {
			return new CurrentForecastBean();
		}

		CurrentForecastBean forecast = new CurrentForecastBean();
		forecast.setInstant(forecastDto.getInstant());

		forecastDtoOptional
		.map(CurrentForecastDto::getAtmosphere)
		.ifPresent( atmosphereDto -> {
			forecast.setTemperature(atmosphereDto.getTemperature());
			forecast.setHumidity(atmosphereDto.getHumidity());
		});

		forecastDtoOptional
		.map(CurrentForecastDto::getSky)
		.ifPresent( skyDtoList -> {
			skyDtoList.stream().findFirst().ifPresent( skyDto -> {
				forecast.setWeatherName(skyDto.getMain());
				forecast.setWeatherDescription(skyDto.getDescription());
			});
		});

		forecast.setRain(forecastDto.getRain());

		forecast.setCityId(forecastDto.getCityId());
		forecast.setCityName(forecastDto.getCityName());

		return forecast;
	}

}
