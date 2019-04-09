package com.nextoo.asenoussi.ex1.dto.transformer;

import com.nextoo.asenoussi.ex1.api.service.entity.CurrentCondition;
import com.nextoo.asenoussi.ex1.dto.CurrentConditionDto;

public class CurrentConditionTransformer {
	private CurrentConditionTransformer() {}
	
	public static CurrentCondition dtoToEntity(CurrentConditionDto currentDto) {
		if(currentDto != null) {
			CurrentCondition current = new CurrentCondition();
			
			current.setHumidity(currentDto.getHumidity());
			current.setCondition(currentDto.getCondition());
			current.setHour(currentDto.getHour());
			current.setTemperature(currentDto.getTemperature());
			current.setImageUrl(currentDto.getImageUrl());
			
			return current;
		}
		return null;
	}
	
	public static CurrentConditionDto entityToDto(CurrentCondition current) {
		if(current != null) {
			CurrentConditionDto currentDto = new CurrentConditionDto();
			
			currentDto.setHumidity(current.getHumidity());
			currentDto.setCondition(current.getCondition());
			currentDto.setHour(current.getHour());
			currentDto.setTemperature(current.getTemperature());
			currentDto.setImageUrl(current.getImageUrl());
			
			return currentDto;
		}
		return null;
	}
}
