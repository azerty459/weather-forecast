package com.projet.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PrevisionCityDto { 

	private CityInfoDto cityInfo;
	private ForecastInfoDto forecastInfo;
	private CurrentConditionDto currentCondition;
	private List<DayDto> listOfDays = new ArrayList<>();

	//Force à passer par le constructeur
	@JsonCreator
	public PrevisionCityDto(@JsonProperty("city_info")CityInfoDto city, 
							@JsonProperty("forecast_info")ForecastInfoDto forecast,
							@JsonProperty("current_condition")CurrentConditionDto current,
							@JsonProperty("fcst_day_0") DayDto day0,
							@JsonProperty("fcst_day_1") DayDto day1,
							@JsonProperty("fcst_day_2") DayDto day2,
							@JsonProperty("fcst_day_3") DayDto day3,
							@JsonProperty("fcst_day_4") DayDto day4) 
	{
		this.cityInfo = city;
		this.forecastInfo = forecast;
		this.currentCondition = current;
		this.listOfDays.clear();
		this.listOfDays.add(day0);
		this.listOfDays.add(day1);
		this.listOfDays.add(day2);
		this.listOfDays.add(day3);
		this.listOfDays.add(day4);
	}

	public CityInfoDto getCityInfo() {
		return cityInfo;
	}

	public void setCityInfo(CityInfoDto cityInfo) {
		this.cityInfo = cityInfo;
	}

	public ForecastInfoDto getForecastInfo() {
		return forecastInfo;
	}

	public void setForecastInfo(ForecastInfoDto forecastInfo) {
		this.forecastInfo = forecastInfo;
	}

	public CurrentConditionDto getCurrentCondition() {
		return currentCondition;
	}

	public void setCurrentCondition(CurrentConditionDto currentCondition) {
		this.currentCondition = currentCondition;
	}

	public List<DayDto> getListOfDays() {
		return listOfDays;
	}

	public void setListOfDays(List<DayDto> listOfDays) {
		this.listOfDays = listOfDays;
	}

	
}
