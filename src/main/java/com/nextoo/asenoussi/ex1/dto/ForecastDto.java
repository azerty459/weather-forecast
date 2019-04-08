package com.nextoo.asenoussi.ex1.dto;

import java.util.Map;

public class ForecastDto {
	
	String date;
	
	double tempMin;
	
	double tempMax;
	
	String condition;

	Map<String, HourlyDataDto> hourlyData;
	
	String jourSemaine;
	
	double avgTemp;

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

	public Map<String, HourlyDataDto> getHourlyData() {
		return hourlyData;
	}

	public void setHourlyData(Map<String, HourlyDataDto> hourlyData) {
		this.hourlyData = hourlyData;
	}
	
	public String getJourSemaine() {
		return jourSemaine;
	}

	public void setJourSemaine(String jourSemaine) {
		this.jourSemaine = jourSemaine;
	}

	public double getAvgTemp() {
		return avgTemp;
	}

	public void setAvgTemp(double avgTemp) {
		this.avgTemp = avgTemp;
	}
	
	
	
}
