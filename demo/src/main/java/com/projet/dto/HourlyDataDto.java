package com.projet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class HourlyDataDto {

	@JsonProperty("RH2m")
	private int humidity;

	
	public int getHumidity() {
		return humidity;
	}

	
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	
	
}
