package com.nextoo.asenoussi.ex1.api.service.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Forecast{
	@JsonProperty("date")
	private String date;
	
	@JsonProperty("tmin")
	private double tempMin;
	
	@JsonProperty("tmax")
	private double tempMax;
	
	@JsonProperty("condition")
	private String condition;
	
	@JsonProperty("day_long")
	private String jourSemaine;
	
	@JsonProperty("hourly_data")
	private Map<String, HourlyData> hourlyData;
	
	@JsonProperty("icon")
	private String imageUrl;

	public String getDate() {return date;}

	public void setDate(String date) {this.date = date;}

	public double getTempMin() {return tempMin;}

	public void setTempMin(double tempMin) {this.tempMin = tempMin;}

	public double getTempMax() {return tempMax;}

	public void setTempMax(double tempMax) {this.tempMax = tempMax;}
	
	public String getCondition() {return condition;}

	public void setCondition(String condition) {this.condition = condition;}

	public Map<String, HourlyData> getHourlyData() {return hourlyData;}

	public void setHourlyData(Map<String, HourlyData> hourlyData) {this.hourlyData = hourlyData;}

	public String getJourSemaine() {return jourSemaine;}

	public void setJourSemaine(String jourSemaine) {this.jourSemaine = jourSemaine;}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	
	
	
}
