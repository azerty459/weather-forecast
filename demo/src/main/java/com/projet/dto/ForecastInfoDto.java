package com.projet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ForecastInfoDto {

	@JsonProperty("latitude")
	 private String latitude;
	@JsonProperty("longitude")
	 private String longitude;
	@JsonProperty("elevation")
	 private String elevation;
	
	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String getElevation() {
		return elevation;
	}
	
	public void setElevation(String elevation) {
		this.elevation = elevation;
	}
}

