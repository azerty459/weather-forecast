package com.nextoo.meteo.services;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.nextoo.meteo.api.WeatherApi;
import com.nextoo.meteo.api.dto.Forecast;
import com.nextoo.meteo.api.dto.ForecastWrapper;
import com.nextoo.meteo.dto.NextooForecast;
import com.nextoo.meteo.dto.NextooForecastWrapper;
import com.nextoo.meteo.dto.NextooHumidityForecast;
import com.nextoo.meteo.transformer.ForecastTransformer;
import com.nextoo.meteo.utils.KeyPair;
import com.nextoo.meteo.utils.StreamUtils;

public class ForecastServiceImpl implements ForecastService {

	@Autowired
	private WeatherApi weatherApi;

	@Autowired
	private ForecastTransformer forecastTransformer;

	@Override
	public Optional<NextooForecastWrapper> forecastCity(String city) {

		Optional<ForecastWrapper> forecast = weatherApi.forecastAndNow(city);
		if (forecast.isEmpty())
			return Optional.empty();

		Optional<NextooForecastWrapper> nextooForecast = forecastTransformer.toNextoo(forecast.get());
		if (nextooForecast.isEmpty())
			return Optional.empty();

		nextooForecast.get().setVille(city);

		return nextooForecast;
	}

	@Override
	public Optional<NextooHumidityForecast> humidityAnalyse(String city) {
		Optional<ForecastWrapper> forecast = weatherApi.forecastAndNow(city);
		if (forecast.isEmpty())
			return Optional.empty();

		Integer actualHumidity = forecast.get().getActually().getWeatherInfo().getHumidity();

		Map<String, List<Forecast>> daily = forecast.get().getForcast().stream()
				.map(f -> f.getDatetime().substring(0, 10)).distinct()
				.map(day -> new KeyPair<>(day,
						forecast.get().getForcast().stream().filter(f -> f.getDatetime().startsWith(day))
								.collect(Collectors.toList())))
				.collect(Collectors.toMap(KeyPair::getKey, KeyPair::getValue));

		Map<String, Double> dailyAverage = StreamUtils.stream(daily)
				.map(kv -> new KeyPair<String, Double>(kv.getKey(),
						kv.getValue().stream()
								.collect(Collectors.averagingDouble(f -> (double) f.getWeatherInfo().getHumidity()))))
				.collect(Collectors.toMap(KeyPair::getKey, KeyPair::getValue));

		Optional<KeyPair<String, Double>> dryestDay = StreamUtils.stream(dailyAverage)
				.min(Comparator.comparing(KeyPair::getValue));
		if (dryestDay.isEmpty())
			return Optional.empty();

		List<Forecast> dryestDayForecast = forecast.get().getForcast().stream()
				.filter(f -> f.getDatetime().startsWith(dryestDay.get().getKey())).collect(Collectors.toList());
		List<NextooForecast> nextooDryestDayForecast = forecastTransformer.toNextoo(dryestDayForecast);

		return Optional.of(NextooHumidityForecast.builder().ville(city).humiditeActuelle(actualHumidity)
				.humiditeMoyen(dailyAverage).lePluSec(nextooDryestDayForecast).build());
	}

	@Override
	public Optional<NextooForecast> hotestDay(String city) {
		Optional<ForecastWrapper> forecast = weatherApi.forecastAndNow(city);
		if (forecast.isEmpty())
			return Optional.empty();

		Optional<Forecast> hotest = forecast.get().getForcast().stream()
				.max(Comparator.comparing(f -> f.getWeatherInfo().getTemperature()));
		if (hotest.isEmpty())
			return Optional.empty();

		return Optional.of(forecastTransformer.toNextoo(hotest.get()));
	}

	@Override
	public Optional<NextooForecastWrapper> rainingDays(String city) {
		Optional<ForecastWrapper> forecast = weatherApi.forecastAndNow(city);
		if (forecast.isEmpty())
			return Optional.empty();

		List<Forecast> raining = forecast.get().getForcast().stream()
				.filter(f -> f.getWeather().stream().anyMatch(w -> w.getDescription().contains("pluie")))
				.collect(Collectors.toList());

		forecast.get().setForcast(raining);

		Optional<NextooForecastWrapper> nextooForecast = forecastTransformer.toNextoo(forecast.get());
		if (nextooForecast.isEmpty())
			return Optional.empty();

		nextooForecast.get().setVille(city);
		return nextooForecast;
	}

}
