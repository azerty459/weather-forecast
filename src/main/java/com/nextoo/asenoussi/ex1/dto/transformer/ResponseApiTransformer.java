package com.nextoo.asenoussi.ex1.dto.transformer;

import java.util.ArrayList;
import java.util.List;

import com.nextoo.asenoussi.ex1.api.service.entity.ResponseApi;
import com.nextoo.asenoussi.ex1.dto.ForecastDto;
import com.nextoo.asenoussi.ex1.dto.ResponseApiDto;

public class ResponseApiTransformer {
	private ResponseApiTransformer() {}
	
	public static ResponseApi dtoToEntity(ResponseApiDto responseDto) {
		if(responseDto != null) {
			ResponseApi response = new ResponseApi();
			
			response.setCityInfo(CityInfoTransformer.dtoToEntity(responseDto.getCityInfo()));
			response.setCurrentCondition(CurrentConditionTransformer.dtoToEntity(responseDto.getCurrentCondition()));
			
			List<ForecastDto> forecastsDto = new ArrayList<>(responseDto.getForecasts());
			response.setForecastJ0(ForecastTransformer.dtoToentity(forecastsDto.get(0)));
			response.setForecastJ1(ForecastTransformer.dtoToentity(forecastsDto.get(1)));
			response.setForecastJ2(ForecastTransformer.dtoToentity(forecastsDto.get(2)));
			response.setForecastJ3(ForecastTransformer.dtoToentity(forecastsDto.get(3)));
			
			return response;
		}
		return null;
	}
	
	public static ResponseApiDto entityToDto(ResponseApi response) {
		if(response != null) {
			ResponseApiDto responseDto = new ResponseApiDto();
			
			responseDto.setCityInfo(CityInfoTransformer.entityToDto(response.getCityInfo()));
			responseDto.setCurrentCondition(CurrentConditionTransformer.entityToDto(response.getCurrentCondition()));
			List<ForecastDto> forecasts = new ArrayList<>();
			forecasts.add(ForecastTransformer.entityToDto(response.getForecastJ0()));
			forecasts.add(ForecastTransformer.entityToDto(response.getForecastJ1()));
			forecasts.add(ForecastTransformer.entityToDto(response.getForecastJ2()));
			forecasts.add(ForecastTransformer.entityToDto(response.getForecastJ3()));
			responseDto.setForecast(forecasts);
			
			return responseDto;
		}
		return null;
	}
	
}
