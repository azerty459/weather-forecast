package com.nextoo.asenoussi.ex1.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ForecastDto {
	@JsonProperty("date")
	String date;
	
	@JsonProperty("tmin")
	double tempMin;
	
	@JsonProperty("tmax")
	double tempMax;
	
	@JsonProperty("condition")
	String condition;
	
	@JsonProperty("hourly_data")
	Map<String, HourlyDataDto> hourlyData;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getTempMin() {
		return tempMin;
	}

	public void setTempMin(double tempMin) {
		this.tempMin = tempMin;
	}

	public double getTempMax() {
		return tempMax;
	}

	public void setTempMax(double tempMax) {
		this.tempMax = tempMax;
	}
	
	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public double getAverageTemperature() {
		return (tempMax + tempMin) / 2; 
	}

	public Map<String, HourlyDataDto> getHourlyData() {
		return hourlyData;
	}

	public void setHourlyData(Map<String, HourlyDataDto> hourlyData) {
		this.hourlyData = hourlyData;
	}
	
	
	
	
	
}
