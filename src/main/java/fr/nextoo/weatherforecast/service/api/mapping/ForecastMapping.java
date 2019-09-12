package fr.nextoo.weatherforecast.service.api.mapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import fr.nextoo.weatherforecast.service.api.dto.AtmosphereDto;
import fr.nextoo.weatherforecast.service.api.dto.CurrentForecastDto;
import fr.nextoo.weatherforecast.service.api.dto.DaysListForecastsDto;
import fr.nextoo.weatherforecast.service.api.dto.ForecastDto;
import fr.nextoo.weatherforecast.service.api.dto.SkyDto;
import fr.nextoo.weatherforecast.utils.DateUtils;
import fr.nextoo.weatherforecast.web.bean.CityBean;
import fr.nextoo.weatherforecast.web.bean.DayForecastBean;
import fr.nextoo.weatherforecast.web.bean.DaysListForecastsDetailsBean;
import fr.nextoo.weatherforecast.web.bean.ForecastsDetailsBean;
import fr.nextoo.weatherforecast.web.bean.ForecastBean;

public class ForecastMapping {

	/**
	 * Map Forecast Dto list to ForecastsDetails list
	 * @param forecastsDto
	 * @return DailyForecastBean list
	 */
	public static DaysListForecastsDetailsBean mappingForecastsDtoListToForecastsDetailsBeanList(DaysListForecastsDto daysListDto) {
		Optional<DaysListForecastsDto> daysListOptional = Optional.ofNullable(daysListDto);

		if(daysListOptional.isEmpty()) {
			return null;
		}

		DaysListForecastsDetailsBean daysList = new DaysListForecastsDetailsBean();
				
		// map forecasts Dto list to Bean list
		List<ForecastBean> forecastsBean = mappingForecastsDtoListToBeanList(daysListDto.getForecasts());

		// construct a Map
		// key   -> day
		// value -> forecasts list of the day
		Map<LocalDate, List<ForecastBean>> forecastsByDay = forecastsBean
				.stream()
				.collect(Collectors.groupingBy(
						forecast -> DateUtils.formattingInstantToLocalDate(forecast.getInstant()) 
				));

		// convert the Map forecastByDay into a ForecastsDetailsBean list
		List<ForecastsDetailsBean> forecastsDetailsList = forecastsByDay
				.entrySet()
				.stream()
				.map(m->new ForecastsDetailsBean(m.getKey(), m.getValue()))
				.collect(Collectors.toList());
		
		daysList.setForecastsDetailsList(forecastsDetailsList);
		daysList.setCity(mappingCityDtoToBean(daysListDto));
		
		return daysList;
		
	}

	/**
	 * 
	 * @param daysListDto
	 * @return
	 */
	private static CityBean mappingCityDtoToBean(DaysListForecastsDto daysListDto) {
		CityBean city = new CityBean();
		city.setId(daysListDto.getCityId());
		city.setName(daysListDto.getCityName());
		return city;
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
			return null;
		}

		ForecastBean forecast = new ForecastBean();
		forecast.setInstant(forecastDto.getInstant());

		forecastDtoOptional
			.map(ForecastDto::getAtmosphere)
			.ifPresent( atmosphereDto -> {
				mappingAtmosphereDtoIntoForecastBean(atmosphereDto, forecast);
			}
		);

		forecastDtoOptional
			.map(ForecastDto::getSky)
			.ifPresent( skyDtoList -> {
				skyDtoList.stream().findFirst().ifPresent( skyDto -> {
					mappingSkyDtoIntoForecastBean(skyDto, forecast);
				});
			});
		
		forecast.setRain(forecastDto.getRain());

		return forecast;
	}

	/**
	 * 
	 * @param skyDto
	 * @param forecast
	 */
	private static void mappingSkyDtoIntoForecastBean(SkyDto skyDto, ForecastBean forecast) {
		forecast.setWeatherName(skyDto.getMain());
		forecast.setWeatherDescription(skyDto.getDescription());
	}

	/**
	 * 
	 * @param atmosphereDto
	 * @param forecast
	 */
	private static void mappingAtmosphereDtoIntoForecastBean( AtmosphereDto atmosphereDto, ForecastBean forecast) {
		forecast.setTemperature(atmosphereDto.getTemperature());
		forecast.setHumidity(atmosphereDto.getHumidity());
	}

	/**
	 * Map Current Forecast Dto to Bean
	 * @param currentForecastDto
	 * @return
	 */
	public static DayForecastBean mappingCurrentForecastDtoToBean(CurrentForecastDto forecastDto) {
		Optional<CurrentForecastDto> forecastDtoOptional = Optional.ofNullable(forecastDto);

		if(forecastDtoOptional.isEmpty()) {
			return null;
		}

		DayForecastBean forecast = new DayForecastBean();
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

		CityBean city = new CityBean();
		city.setId(forecastDto.getCityId());
		city.setName(forecastDto.getCityName());
		forecast.setCity(city);

		return forecast;
	}

}
