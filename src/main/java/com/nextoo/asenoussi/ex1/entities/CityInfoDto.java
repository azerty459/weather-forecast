package com.nextoo.asenoussi.ex1.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CityInfoDto {
	
	@JsonProperty("name")
	String nomLocalite;
	
	@JsonProperty("latitude")
	String latitude;
	
	@JsonProperty("longitude")
	String longitude;

	public String getNomLocalite() {
		return nomLocalite;
	}

	public void setNomLocalite(String nomLocalite) {
		this.nomLocalite = nomLocalite;
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
