package com.nextoo.asenoussi.ex1.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ResponseApiDto {
	
	@JsonProperty("city_info")
	CityInfoDto cityInfo;
	
	@JsonProperty("fcst_day_0")
	ForecastDto forecastJ0;
	
	@JsonProperty("fcst_day_1")
	ForecastDto forecastJ1;
	
	@JsonProperty("fcst_day_2")
	ForecastDto forecastJ2;
	
	@JsonProperty("fcst_day_3")
	ForecastDto forecastJ3;
	
	List<ForecastDto> forecasts = new ArrayList<>();
	
	@JsonProperty("fcst_day_%d")
	Map<String, ForecastDto> prevs;
	
	@JsonProperty("current_condition")
	CurrentConditionDto currentCondition;

	public CityInfoDto getCityInfo() {
		return cityInfo;
	}

	public void setCityInfo(CityInfoDto cityInfo) {
		this.cityInfo = cityInfo;
	}
	
	public Collection<ForecastDto> getForecasts(){
		forecasts.clear();
		forecasts.add(forecastJ0);
		forecasts.add(forecastJ1);
		forecasts.add(forecastJ2);
		forecasts.add(forecastJ3);
		return forecasts;
	}

	public CurrentConditionDto getCurrentCondition() {
		return currentCondition;
	}

	public void setCurrentCondition(CurrentConditionDto currentCondition) {
		this.currentCondition = currentCondition;
	}
	
	
	
	
}
