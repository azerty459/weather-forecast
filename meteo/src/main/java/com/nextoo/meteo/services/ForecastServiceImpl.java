package com.nextoo.meteo.services;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nextoo.meteo.api.WeatherApi;
import com.nextoo.meteo.api.dto.ForecastDto;
import com.nextoo.meteo.api.dto.ForecastWrapperDto;
import com.nextoo.meteo.dto.NextooForecast;
import com.nextoo.meteo.dto.NextooForecastWrapper;
import com.nextoo.meteo.dto.NextooHumidityForecast;
import com.nextoo.meteo.transformer.ForecastTransformer;
import com.nextoo.meteo.utils.KeyPair;
import com.nextoo.meteo.utils.StreamUtils;

@Component
public class ForecastServiceImpl implements ForecastService {

	@Autowired
	private WeatherApi weatherApi;

	@Autowired
	private ForecastTransformer forecastTransformer;

	@Override
	public Optional<NextooForecastWrapper> forecastCity(String city) {

		Optional<ForecastWrapperDto> forecast = weatherApi.forecastAndNow(city);
		if (!forecast.isPresent())
			return Optional.empty();

		Optional<NextooForecastWrapper> nextooForecast = forecastTransformer.toNextoo(forecast.get());
		if (!nextooForecast.isPresent())
			return Optional.empty();

		nextooForecast.get().setVille(city);

		return nextooForecast;
	}

	@Override
	public Optional<NextooHumidityForecast> humidityAnalyse(String city) {
		Optional<ForecastWrapperDto> forecast = weatherApi.forecastAndNow(city);
		if (!forecast.isPresent())
			return Optional.empty();

		Integer actualHumidity = forecast.get().getActually().getWeatherInfo().getHumidity();

		Map<String, List<ForecastDto>> daily = groupByDay(forecast.get());

		Map<String, Double> dailyAverage = StreamUtils.stream(daily)
				.map(kv -> new KeyPair<String, Double>(kv.getKey(),
						kv.getValue().stream()
								.collect(Collectors.averagingDouble(f -> (double) f.getWeatherInfo().getHumidity()))))
				.collect(Collectors.toMap(KeyPair::getKey, KeyPair::getValue));

		Optional<KeyPair<String, Double>> dryestDay = StreamUtils.stream(dailyAverage)
				.min(Comparator.comparing(KeyPair::getValue));
		if (!dryestDay.isPresent())
			return Optional.empty();

		List<ForecastDto> dryestDayForecast = forecast.get().getForcast().stream()
				.filter(f -> f.getDatetime().startsWith(dryestDay.get().getKey())).collect(Collectors.toList());
		List<NextooForecast> nextooDryestDayForecast = forecastTransformer.toNextoo(dryestDayForecast);

		return Optional.of(NextooHumidityForecast.builder().ville(city).humiditeActuelle(actualHumidity)
				.humiditeMoyen(dailyAverage).lePluSec(nextooDryestDayForecast).build());
	}

	@Override
	public Optional<NextooForecast> hotestDay(String city) {
		Optional<ForecastWrapperDto> forecast = weatherApi.forecastAndNow(city);
		if (!forecast.isPresent())
			return Optional.empty();

		Optional<ForecastDto> hotest = forecast.get().getForcast().stream()
				.max(Comparator.comparing(f -> f.getWeatherInfo().getTemperature()));
		if (!hotest.isPresent())
			return Optional.empty();

		return Optional.of(forecastTransformer.toNextoo(hotest.get()));
	}

	@Override
	public Optional<List<String>> rainingDays(String city) {
		Optional<ForecastWrapperDto> forecast = weatherApi.forecastAndNow(city);
		if (!forecast.isPresent())
			return Optional.empty();
		
		Map<String, List<ForecastDto>> daily = groupByDay(forecast.get());

		return Optional.of(StreamUtils.stream(daily)
				.filter(kv -> kv.getValue().stream().anyMatch(
						f -> f.getWeather().stream().anyMatch(w -> w.getDescription().contains("pluie"))))
						.map(KeyPair::getKey)
						.collect(Collectors.toList()));
	}

	private Map<String, List<ForecastDto>> groupByDay(ForecastWrapperDto forecast) {
		return forecast.getForcast().stream().map(f -> f.getDatetime().substring(0, 10)).distinct()
				.map(day -> new KeyPair<String, List<ForecastDto>>(day,
						forecast.getForcast().stream().filter(f -> f.getDatetime().startsWith(day))
								.collect(Collectors.toList())))
				.collect(Collectors.toMap(KeyPair::getKey, KeyPair::getValue));
	}

}
