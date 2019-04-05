package com.projet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CurrentConditionDto {

	@JsonProperty("date")
	private String date;
	@JsonProperty("hour")
	private String hour;
	@JsonProperty("humidity")
	private int humidity;
	@JsonProperty("tmp")
	private int temp;
	@JsonProperty("condition")
	private String condition;
	
	
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidit) {
		this.humidity = humidit;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
}
