package com.nextoo.meteo.transformer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.nextoo.meteo.api.dto.ForecastDto;
import com.nextoo.meteo.api.dto.ForecastWrapperDto;
import com.nextoo.meteo.api.dto.WeatherDto;
import com.nextoo.meteo.dto.NextooForecast;
import com.nextoo.meteo.dto.NextooForecastWrapper;

@Component
public class ForecastTransformer {

	public Optional<NextooForecastWrapper> toNextoo(ForecastWrapperDto forecast) {

		if (forecast.getCode() != 200)
			return Optional.empty();
		else
			return Optional.of(NextooForecastWrapper.builder().actuellement(toNextoo(forecast.getActually()))
					.previsions(toNextoo(forecast.getForcast())).build());
	}

	public NextooForecast toNextoo(ForecastDto forecast) {
		return NextooForecast.builder().dateEtHeure(forecast.getDatetime())
				.temps(forecast.getWeather().stream().map(WeatherDto::getDescription).collect(Collectors.joining(",")))
				.temperature(forecast.getWeatherInfo().getTemperature())
				.temperatureMinimum(forecast.getWeatherInfo().getTemperatureMinimum())
				.temperatureMaximum(forecast.getWeatherInfo().getTemperatureMaximum())
				.humidite(forecast.getWeatherInfo().getHumidity())
				.pressionAtmospherique(forecast.getWeatherInfo().getPressure()).build();
	}

	public List<NextooForecast> toNextoo(List<ForecastDto> forecast) {
		return forecast.stream().map(this::toNextoo).collect(Collectors.toList());
	}
}
