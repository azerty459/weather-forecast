package com.nextoo.asenoussi.ex1.dto;

import java.util.ArrayList;
import java.util.Collection;


public class ResponseApiDto {

	private CityInfoDto cityInfo;
	
	private Collection<ForecastDto> forecasts = new ArrayList<>();
	
	private CurrentConditionDto currentCondition;

	public CityInfoDto getCityInfo() {
		return cityInfo;
	}

	public void setCityInfo(CityInfoDto cityInfo) {
		this.cityInfo = cityInfo;
	}
	
	public void setForecast(Collection<ForecastDto> forecasts) {
		this.forecasts = forecasts;
	}
	
	public Collection<ForecastDto> getForecasts(){return forecasts;}

	public CurrentConditionDto getCurrentCondition() {
		return currentCondition;
	}

	public void setCurrentCondition(CurrentConditionDto currentCondition) {
		this.currentCondition = currentCondition;
	}

}

