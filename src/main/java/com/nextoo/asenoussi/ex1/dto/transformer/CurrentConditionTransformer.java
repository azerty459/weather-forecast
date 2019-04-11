package com.nextoo.asenoussi.ex1.dto.transformer;

import com.nextoo.asenoussi.ex1.api.service.entity.CurrentCondition;
import com.nextoo.asenoussi.ex1.dto.CurrentConditionDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CurrentConditionTransformer {
	private CurrentConditionTransformer() {}

	private static  String DATE_PATTERN = "dd.MM.yyyy";

	public static CurrentCondition dtoToEntity(CurrentConditionDto currentDto) {
		if(currentDto != null) {
			CurrentCondition current = new CurrentCondition();
			
			current.setHumidity(currentDto.getHumidity());
			current.setCondition(currentDto.getCondition());
			current.setHour(currentDto.getHour());
			current.setTemperature(currentDto.getTemperature());
			current.setImageUrl(currentDto.getImageUrl());

			if(currentDto.getDate() != null) {
				SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN);
				current.setDate(format.format(currentDto.getDate()));
			}
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

			if(current.getDate() != null) {
				SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN);
				try {
					currentDto.setDate(format.parse(current.getDate()));
				} catch (ParseException e) {
					currentDto.setDate(null);
				}
			}

			return currentDto;
		}
		return null;
	}
}
