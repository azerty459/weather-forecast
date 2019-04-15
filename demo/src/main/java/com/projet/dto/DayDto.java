package com.projet.dto;

import java.util.HashMap;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class DayDto {

	@JsonProperty("date")
	private String date;

	@JsonProperty("day_long")
	private String nameOfDay;

	@JsonProperty("condition")
	private String condition;
	
	@JsonProperty("tmin")
	private int tempMin;
	
	@JsonProperty("tmax")
	private int tempMax;
	
	@JsonProperty("icon_big")
	private String icon;

	public int getTempMin() {
		return tempMin;
	}

	public void setTempMin(int tempMin) {
		this.tempMin = tempMin;
	}

	@JsonProperty("hourly_data")
	private Map<String, HourlyDataDto> hourlyData = new HashMap<>();


	public Map<String, HourlyDataDto> getHourlyData() {
		return hourlyData;
	}

	public void setHourlyData(Map<String, HourlyDataDto> hourlyData) {
		this.hourlyData = hourlyData;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNameOfDay() {
		return nameOfDay;
	}

	public void setNameOfDay(String nameOfDay) {
		this.nameOfDay = nameOfDay;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getTempMax() {
		return tempMax;
	}

	public void setTempMax(int tempMax) {
		this.tempMax = tempMax;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}



}