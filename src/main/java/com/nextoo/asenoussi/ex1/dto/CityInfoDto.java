package com.nextoo.asenoussi.ex1.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CityInfoDto {
	
	@JsonProperty("name")
	String nomLocale;
	
	@JsonProperty("latitude")
	String latitude;
	
	@JsonProperty("longitude")
	String longitude;

	public String getNomLocalite() {
		return nomLocale;
	}

	public void setNomLocalite(String nomLocalite) {
		this.nomLocale = nomLocalite;
	}

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
	
	
}
