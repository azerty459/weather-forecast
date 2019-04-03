package com.nextoo.asenoussi.ex1.service;

import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextoo.asenoussi.ex1.api.service.ApiService;
import com.nextoo.asenoussi.ex1.dto.HumidityResponseDto;
import com.nextoo.asenoussi.ex1.dto.ForecastDto;
import com.nextoo.asenoussi.ex1.dto.ResponseApiDto;

@Service
public class MeteoServiceImpl implements WeatherService{
	@Autowired
	ApiService apiService;
	
	@Override
	public ForecastDto getMostHotDayOfWeek(String cityName) {
		ResponseApiDto response = apiService.getDataFromCityName(cityName);
		return response.getForecasts().stream().max(
				Comparator.comparingDouble(ForecastDto::getAverageTemperature)
		).get();
	}
	
	public ForecastDto[] getDayWithRain(String cityName){
		ResponseApiDto response = apiService.getDataFromCityName(cityName);
		return response.getForecasts().stream().filter(
				p -> (p.getCondition().toLowerCase().contains("pluie")
		)).toArray(ForecastDto[]::new);
	}
	
	public HumidityResponseDto getHumidityData(String cityName) {
		ResponseApiDto response = apiService.getDataFromCityName(cityName);
		HumidityResponseDto humidityResponse = new HumidityResponseDto();
		
		humidityResponse.setCurrentHumidity(response.getCurrentCondition().getHumidity());
		
		Double humidityAvg = response.getForecasts().stream().mapToDouble(
				
				p -> p.getHourlyData().values().stream().mapToDouble(
						hourly -> hourly.getHumidity()
				).average().getAsDouble() // avg humididty for all forecast(day of week)
				
		).average().getAsDouble(); // avg humidity for all day in week
		
		humidityResponse.setWeekAvgHumidity(humidityAvg);
		return humidityResponse;
	}

	@Override
	public ResponseApiDto getAllDataFromCityName(String cityName) {
		return apiService.getDataFromCityName(cityName);
	}
	
}
