package com.nextoo.asenoussi.ex1.service;

import com.nextoo.asenoussi.ex1.dto.ForecastDto;
import com.nextoo.asenoussi.ex1.dto.HumidityResponseDto;
import com.nextoo.asenoussi.ex1.dto.ResponseApiDto;

public interface WeatherService {
	ResponseApiDto getAllDataFromCityName(String cityName);
	
	ForecastDto getMostHotDayOfWeek(String cityName);
	
	ForecastDto[] getDayWithRain(String cityName);
	
	HumidityResponseDto getHumidityData(String cityName);

}
