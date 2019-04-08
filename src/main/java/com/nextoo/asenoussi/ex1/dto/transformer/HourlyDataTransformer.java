package com.nextoo.asenoussi.ex1.dto.transformer;

import com.nextoo.asenoussi.ex1.api.service.entity.HourlyData;
import com.nextoo.asenoussi.ex1.dto.HourlyDataDto;

public class HourlyDataTransformer {
	private HourlyDataTransformer() {}
	
	public static HourlyDataDto entityToDto(HourlyData hourly) {
		if(hourly != null) {
			HourlyDataDto hourlyDto = new HourlyDataDto();
			
			hourlyDto.setHumidity(hourly.getHumidity());
			hourlyDto.setPrecipitation(hourly.getPrecipitation());
			
			return hourlyDto;
		}
		return null;
	}
	
	public static HourlyData dtoToentity(HourlyDataDto hourlyDto) {
		if(hourlyDto != null) {
			HourlyData hourly = new HourlyData();
			
			hourly.setHumidity(hourlyDto.getHumidity());
			
			hourly.setPrecipitation(hourlyDto.getPrecipitation());
			
			return hourly;
		}
		return null;
	}
}
