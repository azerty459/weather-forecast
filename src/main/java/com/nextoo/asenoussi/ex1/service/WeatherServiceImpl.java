package com.nextoo.asenoussi.ex1.service;

import com.nextoo.asenoussi.ex1.api.service.ApiService;
import com.nextoo.asenoussi.ex1.dto.ForecastDto;
import com.nextoo.asenoussi.ex1.dto.HourlyDataDto;
import com.nextoo.asenoussi.ex1.dto.HumidityResponseDto;
import com.nextoo.asenoussi.ex1.dto.ResponseApiDto;
import com.nextoo.asenoussi.ex1.dto.transformer.ResponseApiTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Comparator;

@Service
public class WeatherServiceImpl implements WeatherService{
	@Autowired
	ApiService apiService;
	
	@Override
	public ForecastDto getMostHotDayOfWeek(String cityName) {
		ResponseApiDto response = getAllDataFromCityName(cityName);
		if(response != null) {
			return response.getForecasts().stream().max(
					Comparator.comparingDouble(ForecastDto::getAvgTemp)
			).get();
		}
		return null;
	}
	
	public ForecastDto[] getDayWithRain(String cityName){
		ResponseApiDto response = getAllDataFromCityName(cityName);
		if(response != null) {
			return response.getForecasts().stream()
					.filter(
							forecast -> forecast.getHourlyData().values().stream().anyMatch(hourly -> (hourly.getPrecipitation() > 0))
							).toArray(ForecastDto[]::new);
		}
		
		return null;
	}
	
	public HumidityResponseDto getHumidityData(String cityName) {
		ResponseApiDto response = getAllDataFromCityName(cityName);
		if(response != null) {
			HumidityResponseDto humidityResponse = new HumidityResponseDto();
			
			humidityResponse.setCurrentHumidity(response.getCurrentCondition().getHumidity());
			
			double humidityAvg = response.getForecasts().stream().mapToDouble(
					forecast -> forecast.getHourlyData().values().stream().mapToDouble(
							HourlyDataDto::getHumidity
					).average().orElse(0d) // avg humididty for all forecast(day of week)
					
			).average().getAsDouble(); // avg humidity for all day in week
			DecimalFormat df = new DecimalFormat(".##");
			humidityAvg = Double.parseDouble(df.format(humidityAvg).replaceAll(",", "."));
			humidityResponse.setWeekAvgHumidity(humidityAvg);
			return humidityResponse;
		}
		return null;
	}

	@Override
	public ResponseApiDto getAllDataFromCityName(String cityName) {
		if(apiService.getDataFromCityName(cityName) != null && apiService.getDataFromCityName(cityName).getErrors() == null) {
			return ResponseApiTransformer.entityToDto(apiService.getDataFromCityName(cityName));
		}
		else{
			return null;
		}
	}
	
}
