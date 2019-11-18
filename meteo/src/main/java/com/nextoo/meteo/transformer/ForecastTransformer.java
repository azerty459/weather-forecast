package com.nextoo.meteo.transformer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.nextoo.meteo.api.dto.Forecast;
import com.nextoo.meteo.api.dto.ForecastWrapper;
import com.nextoo.meteo.api.dto.Weather;
import com.nextoo.meteo.dto.NextooForecast;
import com.nextoo.meteo.dto.NextooForecastWrapper;

@Component
public class ForecastTransformer {

	public Optional<NextooForecastWrapper> toNextoo(ForecastWrapper forecast) {

		if (forecast.getCode() != 200)
			return Optional.empty();
		else
			return Optional.of(NextooForecastWrapper.builder().actuellement(toNextoo(forecast.getActually()))
					.previsions(toNextoo(forecast.getForcast())).build());
	}

	public NextooForecast toNextoo(Forecast forecast) {
		return NextooForecast.builder().dateEtHeure(forecast.getDatetime())
				.temps(forecast.getWeather().stream().map(Weather::getDescription).collect(Collectors.joining(",")))
				.temperature(forecast.getWeatherInfo().getTemperature())
				.temperatureMinimum(forecast.getWeatherInfo().getTemperatureMinimum())
				.temperatureMaximum(forecast.getWeatherInfo().getTemperatureMaximum())
				.humidite(forecast.getWeatherInfo().getHumidity())
				.pressionAtmospherique(forecast.getWeatherInfo().getPressure()).build();
	}

	public List<NextooForecast> toNextoo(List<Forecast> forecast) {
		return forecast.stream().map(this::toNextoo).collect(Collectors.toList());
	}
}
