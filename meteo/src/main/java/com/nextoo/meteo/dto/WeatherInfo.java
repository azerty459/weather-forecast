package com.nextoo.meteo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({ "sea_level", "grnd_level", "temp_kf" })
public class WeatherInfo {
	
	@JsonProperty("temp")
	private Double temperature;
	
	@JsonProperty("temp_min")
	private Double temperatureMinimum;
	
	@JsonProperty("temp_max")
	private Double temperatureMaximum;
	
	private Double presure;
	
	private Integer humidity;
	
}
