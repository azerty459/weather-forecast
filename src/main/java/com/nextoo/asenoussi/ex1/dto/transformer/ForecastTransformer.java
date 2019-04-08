package com.nextoo.asenoussi.ex1.dto.transformer;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.nextoo.asenoussi.ex1.api.service.entity.Forecast;
import com.nextoo.asenoussi.ex1.api.service.entity.HourlyData;
import com.nextoo.asenoussi.ex1.dto.ForecastDto;
import com.nextoo.asenoussi.ex1.dto.HourlyDataDto;

public class ForecastTransformer {
	private ForecastTransformer() {}
	
	public static ForecastDto entityToDto(Forecast forecast) {
		if(forecast != null) {
			ForecastDto forecastDto = new ForecastDto();
			
			forecastDto.setCondition(forecast.getCondition());
			forecastDto.setDate(forecast.getDate());
			Map<String,HourlyDataDto> map = new HashMap<>();
			for(Entry<String, HourlyData> e : forecast.getHourlyData().entrySet()) {
				map.put(e.getKey(), HourlyDataTransformer.entityToDto(e.getValue()));
			}
			forecastDto.setHourlyData(map);
			forecastDto.setTempMax(forecast.getTempMax());
			forecastDto.setTempMin(forecast.getTempMin());
			forecastDto.setJourSemaine(forecast.getJourSemaine());
			
			return forecastDto;
		}
		return null;
	}

	public static Forecast dtoToentity(ForecastDto forecastDto) {
		if(forecastDto != null) {
			Forecast forecast = new Forecast();
			
			forecast.setCondition(forecastDto.getCondition());
			forecast.setDate(forecastDto.getDate());
			Map<String,HourlyData> map = new HashMap<>();
			for(Entry<String, HourlyDataDto> e : forecastDto.getHourlyData().entrySet()) {
				map.put(e.getKey(), HourlyDataTransformer.dtoToentity(e.getValue()));
			}
			forecast.setHourlyData(map);
			forecast.setTempMax(forecastDto.getTempMax());
			forecast.setTempMin(forecastDto.getTempMin());
			forecast.setJourSemaine(forecastDto.getJourSemaine());
			
			return forecast;
		}
		return null;
	}

}
