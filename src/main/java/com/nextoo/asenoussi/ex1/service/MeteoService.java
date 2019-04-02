package com.nextoo.asenoussi.ex1.service;

import com.nextoo.asenoussi.ex1.entities.HumidityResponseDto;
import com.nextoo.asenoussi.ex1.entities.PrevisionDto;
import com.nextoo.asenoussi.ex1.entities.ResponseDto;

public interface MeteoService {
	public ResponseDto getDataFromCityName(String cityName);
	
	public PrevisionDto getMostHotDayOfWeek(String cityName);
	
	public PrevisionDto[] getDayWithRain(String cityName);
	
	public HumidityResponseDto humidity(String cityName); 

}
