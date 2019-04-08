package com.nextoo.asenoussi.ex1.api.service.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentCondition {
	
	@JsonProperty("humidity")
	private int humidity;
	
	@JsonProperty("hour")
	private String hour;
	
	@JsonProperty("condition")
	private String condition;
	
	@JsonProperty("tmp")
	private int temperature;

	public int getHumidity() {return humidity;}

	public void setHumidity(int humidity) {this.humidity = humidity;}

	public String getHour() {return hour;}

	public void setHour(String hour) {this.hour = hour;}

	public String getCondition() {return condition;}

	public void setCondition(String condition) {this.condition = condition;}

	public int getTemperature() {return temperature;}

	public void setTemperature(int temperature) {this.temperature = temperature;}
	
	
	
}

