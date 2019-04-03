package com.nextoo.asenoussi.ex1.service;

import com.nextoo.asenoussi.ex1.dto.HumidityResponseDto;
import com.nextoo.asenoussi.ex1.dto.ForecastDto;
import com.nextoo.asenoussi.ex1.dto.ResponseApiDto;

public interface WeatherService {
	public ResponseApiDto getAllDataFromCityName(String cityName);
	
	public ForecastDto getMostHotDayOfWeek(String cityName);
	
	public ForecastDto[] getDayWithRain(String cityName);
	
	public HumidityResponseDto getHumidityData(String cityName); 

}
