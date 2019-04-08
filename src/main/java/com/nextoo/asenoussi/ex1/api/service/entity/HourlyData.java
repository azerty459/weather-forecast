package com.nextoo.asenoussi.ex1.api.service.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class HourlyData {

	@JsonProperty("RH2m")
	private int humidity;

	@JsonProperty("APCPsfc")
	private double precipitation;
	
	public int getHumidity() {return humidity;}

	public void setHumidity(int humidity) {this.humidity = humidity;}

	public double getPrecipitation() {return precipitation;}

	public void setPrecipitation(double precipitation) {this.precipitation = precipitation;}
}

